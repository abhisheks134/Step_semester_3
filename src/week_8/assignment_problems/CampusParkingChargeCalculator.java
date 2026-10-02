package week_8.assignment_problems;

import java.util.Scanner;

class Vehicle
{
    String type;
    int hours;

    Vehicle(String type, int hours)
    {
        this.type = type;
        this.hours = hours;
    }

    double calculateCharge()
    {
        return 0;
    }

    void printCharge()
    {
        System.out.printf("%s: %.2f%n", type, calculateCharge());
    }
}

class Bike extends Vehicle
{
    Bike(int hours)
    {
        super("BIKE", hours);
    }

    @Override
    double calculateCharge()
    {
        return 10 * hours;
    }
}

class Car extends Vehicle
{
    Car(int hours)
    {
        super("CAR", hours);
    }

    @Override
    double calculateCharge()
    {
        if (hours == 1)
        {
            return 30;
        }

        return 30 + (20 * (hours - 1));
    }
}

class Truck extends Vehicle
{
    Truck(int hours)
    {
        super("TRUCK", hours);
    }

    @Override
    double calculateCharge()
    {
        double charge = 50 * hours;

        if (charge < 100)
        {
            charge = 100;
        }

        return charge;
    }
}

public class CampusParkingChargeCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Vehicle[] vehicles = new Vehicle[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            int hours = scanner.nextInt();

            if (type.equals("BIKE"))
            {
                vehicles[i] = new Bike(hours);
            }
            else if (type.equals("CAR"))
            {
                vehicles[i] = new Car(hours);
            }
            else
            {
                vehicles[i] = new Truck(hours);
            }
        }

        double total = 0;

        for (Vehicle vehicle : vehicles)
        {
            vehicle.printCharge();
            total = total + vehicle.calculateCharge();
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}