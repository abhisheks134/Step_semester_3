package week_2.assignment_problems;

import java.util.Scanner;

public class LibraryISBNNormalizerValidator
{
    static String normalizeCode(String raw)
    {
        raw = raw.trim();

        if (raw.length() < 3)
        {
            return raw.toUpperCase();
        }

        String publisher = raw.substring(0, 3).toUpperCase();
        String rest = raw.substring(3);

        return publisher + rest;
    }

    static String validateAndFormat(String code)
    {
        if (code.length() != 13)
        {
            return "Invalid: code must be exactly 13 characters";
        }

        for (int i = 0; i < 3; i++)
        {
            if (!Character.isLetter(code.charAt(i)))
            {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++)
        {
            if (!Character.isDigit(code.charAt(i)))
            {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[");
        result.append(code.substring(0, 3));
        result.append("] YEAR: ");
        result.append(code.substring(3, 7));
        result.append(" | CATALOG: ");
        result.append(code.substring(7));

        return result.toString();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ISBN code: ");
        String raw = sc.nextLine();

        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);

        sc.close();
    }
}