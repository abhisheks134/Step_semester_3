
package week_9.class_problems;

import java.util.Scanner;

abstract class Connection
{
    int units;

    Connection(int units)
    {
        this.units = units;
    }

    abstract double calculateBill();
}

class Home extends Connection
{
    Home(int units)
    {
        super(units);
    }

    @Override
    double calculateBill()
    {
        if (units <= 100)
            return units * 5;

        return 100 * 5 + (units - 100) * 7;
    }
}

class Shop extends Connection
{
    Shop(int units)
    {
        super(units);
    }

    @Override
    double calculateBill()
    {
        return units * 8 + 100;
    }
}

class Factory extends Connection
{
    Factory(int units)
    {
        super(units);
    }

    @Override
    double calculateBill()
    {
        return Math.max(units * 6, 1000);
    }
}

public class ElectricityConnectionBilling
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Connection[] connections = new Connection[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equals("HOME"))
                connections[i] = new Home(units);
            else if (type.equals("SHOP"))
                connections[i] = new Shop(units);
            else
                connections[i] = new Factory(units);
        }

        double total = 0;

        for (Connection connection : connections)
        {
            double bill = connection.calculateBill();
            System.out.printf("%s: %.2f%n",
                    connection.getClass().getSimpleName().toUpperCase(), bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}
