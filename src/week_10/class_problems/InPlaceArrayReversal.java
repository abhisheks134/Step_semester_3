
package week_10.class_problems;

import java.util.Scanner;
import java.util.Arrays;

public class InPlaceArrayReversal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++)
        {
            numbers[i] = scanner.nextInt();
        }

        int left = 0;
        int right = n - 1;

        while (left < right)
        {
            int temp = numbers[left];
            numbers[left] = numbers[right];
            numbers[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(numbers));

        scanner.close();
    }
}
