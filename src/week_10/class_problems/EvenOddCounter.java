
package week_10.class_problems;

import java.util.Scanner;

public class EvenOddCounter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++)
        {
            int number = scanner.nextInt();

            if (number % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);

        scanner.close();
    }
}
