package day_1.class_problems;

import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        System.out.println("Iterative: "
                + (isPalindromeIterative(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: "
                + (isPalindromeRecursive(text) ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: "
                + (isPalindromeArrayReversal(text) ? "Palindrome" : "Not Palindrome"));

        scanner.close();
    }

    public static boolean isPalindromeIterative(String text) {
        String value = normalizeText(text);
        int left = 0;
        int right = value.length() - 1;

        while (left < right) {
            if (value.charAt(left) != value.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static boolean isPalindromeRecursive(String text) {
        String value = normalizeText(text);
        return checkRecursively(value, 0, value.length() - 1);
    }

    public static boolean checkRecursively(String text, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return checkRecursively(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        String value = normalizeText(text);
        char[] original = value.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }

        return new String(original).equals(new String(reversed));
    }

    public static String normalizeText(String text) {
        return text.replaceAll("\\s+", "").toLowerCase();
    }
}
