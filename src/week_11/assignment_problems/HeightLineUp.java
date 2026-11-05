package week_11.assignment_problems;

import java.util.*;

public class HeightLineUp {
    public static void lineUp(int[] heights) {
        for (int i = 0; i < heights.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < heights.length - i - 1; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        lineUp(heights);

        sc.close();
    }
}