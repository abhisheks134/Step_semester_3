
package week_9.assignment_problems;

import java.util.Scanner;

interface SaverMode
{
    double SAVER_FACTOR = 0.75;
}

abstract class Appliance
{
    double hours;

    Appliance(double hours)
    {
        this.hours = hours;
    }

    abstract double getPower();

    double calculateUnits()
    {
        return getPower() * hours / 1000;
    }

    double calculateCost()
    {
        return calculateUnits() * 8;
    }
}

class Fridge extends Appliance
{
    Fridge(double hours)
    {
        super(hours);
    }

    @Override
    double getPower()
    {
        return 150;
    }
}

class AC extends Appliance implements SaverMode
{
    boolean saver;

    AC(double hours, boolean saver)
    {
        super(hours);
        this.saver = saver;
    }

    @Override
    double getPower()
    {
        return 1500;
    }

    @Override
    double calculateUnits()
    {
        double units = super.calculateUnits();
        return saver ? units * SAVER_FACTOR : units;
    }
}

class TV extends Appliance
{
    TV(double hours)
    {
        super(hours);
    }

    @Override
    double getPower()
    {
        return 100;
    }
}

class Washer extends Appliance implements SaverMode
{
    boolean saver;

    Washer(double hours, boolean saver)
    {
        super(hours);
        this.saver = saver;
    }

    @Override
    double getPower()
    {
        return 500;
    }

    @Override
    double calculateUnits()
    {
        double units = super.calculateUnits();
        return saver ? units * SAVER_FACTOR : units;
    }
}

public class HomeApplianceEnergyReport
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Appliance[] appliances = new Appliance[n];
        String[] names = new String[n];
        boolean[] invalidSaver = new boolean[n];

        for (int i = 0; i < n; i++)
        {
            names[i] = scanner.next();
            double hours = scanner.nextDouble();
            boolean saver = scanner.hasNext("SAVER");

            if (saver)
                scanner.next();

            if (names[i].equals("FRIDGE"))
            {
                appliances[i] = new Fridge(hours);
                invalidSaver[i] = saver;
            }
            else if (names[i].equals("AC"))
            {
                appliances[i] = new AC(hours, saver);
            }
            else if (names[i].equals("TV"))
            {
                appliances[i] = new TV(hours);
                invalidSaver[i] = saver;
            }
            else
            {
                appliances[i] = new Washer(hours, saver);
            }
        }

        double totalCost = 0;

        for (int i = 0; i < n; i++)
        {
            if (invalidSaver[i])
            {
                System.out.println(names[i] + ": saver mode not supported");
                continue;
            }

            double units = appliances[i].calculateUnits();
            double cost = appliances[i].calculateCost();

            System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                    names[i], units, cost);

            totalCost += cost;
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);

        scanner.close();
    }
}
