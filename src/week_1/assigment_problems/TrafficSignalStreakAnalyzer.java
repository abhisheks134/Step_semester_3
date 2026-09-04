
package week_1.assigment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the traffic signal log (R, Y, G): ");
        String signalLog = scanner.nextLine().trim().toUpperCase();

        findLongestStreak(signalLog);

        scanner.close();
    }

    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("Signal log cannot be empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                currentLength++;
            } else {
                currentColor = signalLog.charAt(i);
                currentLength = 1;
            }

            if (currentLength > longestLength) {
                longestLength = currentLength;
                longestColor = currentColor;
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestLength + " times");
    }
}