
package week_9.assignment_problems;

import java.util.Scanner;

interface NightService
{
    double NIGHT_FACTOR = 1.20;
}

abstract class Cab
{
    double distance;

    Cab(double distance)
    {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateFare()
    {
        return Math.max(calculateBaseFare(), 100);
    }
}

class Mini extends Cab
{
    Mini(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return distance * 10;
    }
}

class Sedan extends Cab implements NightService
{
    Sedan(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return distance * 14;
    }

    @Override
    double calculateFare()
    {
        return super.calculateFare();
    }

    double calculateNightFare()
    {
        return calculateFare() * NIGHT_FACTOR;
    }
}

class SUV extends Cab implements NightService
{
    SUV(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return distance * 18;
    }

    double calculateNightFare()
    {
        return calculateFare() * NIGHT_FACTOR;
    }
}

public class CityCabFareMeter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Cab[] cabs = new Cab[n];
        String[] types = new String[n];
        String[] times = new String[n];

        for (int i = 0; i < n; i++)
        {
            types[i] = scanner.next();
            double km = scanner.nextDouble();
            times[i] = scanner.next();

            if (types[i].equals("MINI"))
                cabs[i] = new Mini(km);
            else if (types[i].equals("SEDAN"))
                cabs[i] = new Sedan(km);
            else
                cabs[i] = new SUV(km);
        }

        double total = 0;

        for (int i = 0; i < n; i++)
        {
            Cab cab = cabs[i];

            if (types[i].equals("MINI") && times[i].equals("NIGHT"))
            {
                System.out.println("MINI: night service not available");
                continue;
            }

            double fare = cab.calculateFare();

            if (times[i].equals("NIGHT"))
                fare *= 1.20;

            System.out.printf("%s: %.2f%n", types[i], fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}
