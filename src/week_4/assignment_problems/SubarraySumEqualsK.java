package week_4.assignment_problems;

import java.util.HashMap;
import java.util.Scanner;

public class SubarraySumEqualsK
{
    static int subarraySum(int[] nums, int k)
    {
        HashMap<Integer, Integer> prefixSum = new HashMap<>();

        // Empty prefix
        prefixSum.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums)
        {
            currentSum += num;

            // Check whether currentSum - k appeared before
            if (prefixSum.containsKey(currentSum - k))
            {
                count += prefixSum.get(currentSum - k);
            }

            // Store current prefix sum
            prefixSum.put(
                currentSum,
                prefixSum.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);

        sc.close();
    }
}
