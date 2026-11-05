package week_11.class_problems;

import java.util.*;

public class EmployeeIDLookup {
    public static int findEmployee(int[] ids, int target) {
        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ids = new int[n];

        for (int i = 0; i < n; i++) {
            ids[i] = sc.nextInt();
        }

        int target = sc.nextInt();
        int result = findEmployee(ids, target);

        if (result == -1) {
            System.out.println("Employee Not Found");
        } else {
            System.out.println("Employee Found at index " + result);
        }

        sc.close();
    }
}