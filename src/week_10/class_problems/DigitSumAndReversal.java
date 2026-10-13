
package week_10.class_problems;

import java.util.Scanner;

public class DigitSumAndReversal
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        int temp = number;
        int sum = 0;
        int reverse = 0;

        while (temp > 0)
        {
            int digit = temp % 10;
            sum += digit;
            reverse = reverse * 10 + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);

        scanner.close();
    }
}

