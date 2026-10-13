
package week_10.class_problems;

import java.util.Scanner;

public class WordReverserPalindromeChecker
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext())
        {
            String word = scanner.next();
            String reversed = new StringBuilder(word).reverse().toString();

            if (word.equals(reversed))
                System.out.println(reversed + " - palindrome");
            else
                System.out.println(reversed + " - not a palindrome");
        }

        scanner.close();
    }
}
