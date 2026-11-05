
package week_11.class_problems;

import java.util.*;

public class WarehouseBinGridScan {
    public static long[] warehouseSummary(int[][] grid) {
        long total = 0;
        int max = grid[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];

                if (grid[i][j] > max) {
                    max = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new long[]{total, maxRow, maxCol};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        long[] result = warehouseSummary(grid);

        System.out.println("Total: " + result[0]);
        System.out.println("Max coordinate: (" + result[1] + ", " + result[2] + ")");

        sc.close();
    }
}
