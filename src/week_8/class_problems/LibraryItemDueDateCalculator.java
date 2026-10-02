package week_8.class_problems;

import java.time.LocalDate;

class LibraryItem
{
    String title;

    LibraryItem(String title)
    {
        this.title = title;
    }

    LocalDate calculateDueDate(LocalDate currentDate)
    {
        return currentDate;
    }

    void printDueDate(LocalDate currentDate)
    {
        System.out.println(title + " - Due Date: " + calculateDueDate(currentDate));
    }
}

class Book extends LibraryItem
{
    Book(String title)
    {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate)
    {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem
{
    DVD(String title)
    {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate)
    {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem
{
    Magazine(String title)
    {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate)
    {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator
{
    public static void main(String[] args)
    {
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        LibraryItem[] items =
        {
            new Book("Java Programming"),
            new DVD("Inception"),
            new Magazine("Tech Monthly")
        };

        for (LibraryItem item : items)
        {
            item.printDueDate(currentDate);
        }
    }
}
