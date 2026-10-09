
package week_9.class_problems;

import java.util.Scanner;

abstract class LibraryItem
{
    String title;
    int daysLate;

    LibraryItem(String title, int daysLate)
    {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();
}

class BookItem extends LibraryItem
{
    BookItem(String title, int daysLate)
    {
        super(title, daysLate);
    }

    @Override
    double calculateFine()
    {
        return daysLate * 2.0;
    }
}

class DVDItem extends LibraryItem
{
    DVDItem(String title, int daysLate)
    {
        super(title, daysLate);
    }

    @Override
    double calculateFine()
    {
        return Math.min(daysLate * 5.0, 50.0);
    }
}

class MagazineItem extends LibraryItem
{
    MagazineItem(String title, int daysLate)
    {
        super(title, daysLate);
    }

    @Override
    double calculateFine()
    {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            String title = scanner.next();
            int daysLate = scanner.nextInt();

            if (type.equals("BOOK"))
            {
                items[i] = new BookItem(title, daysLate);
            }
            else if (type.equals("DVD"))
            {
                items[i] = new DVDItem(title, daysLate);
            }
            else
            {
                items[i] = new MagazineItem(title, daysLate);
            }
        }

        double total = 0;

        for (LibraryItem item : items)
        {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f%n", item.title, fine);
            total += fine;
        }

        System.out.printf("Total Fines: %.2f%n", total);

        scanner.close();
    }
}
