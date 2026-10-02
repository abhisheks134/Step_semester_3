package week_8.assignment_problems;

import java.util.Scanner;

class Room
{
    String type;
    int units;

    Room(String type, int units)
    {
        this.type = type;
        this.units = units;
    }

    double calculateBill()
    {
        return 0;
    }

    void printBill()
    {
        System.out.printf("%s: %.2f%n", type, calculateBill());
    }
}

class SingleRoom extends Room
{
    SingleRoom(int units)
    {
        super("SINGLE", units);
    }

    @Override
    double calculateBill()
    {
        return 8 * units;
    }
}

class SharedRoom extends Room
{
    int occupants;

    SharedRoom(int units, int occupants)
    {
        super("SHARED", units);
        this.occupants = occupants;
    }

    @Override
    double calculateBill()
    {
        return (6 * units) / (double) occupants;
    }
}

class ACRoom extends Room
{
    ACRoom(int units)
    {
        super("AC", units);
    }

    @Override
    double calculateBill()
    {
        return (10 * units) + 200;
    }
}

public class HostelElectricityBill
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Room[] rooms = new Room[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            int units = scanner.nextInt();

            if (type.equals("SINGLE"))
            {
                rooms[i] = new SingleRoom(units);
            }
            else if (type.equals("SHARED"))
            {
                int occupants = scanner.nextInt();
                rooms[i] = new SharedRoom(units, occupants);
            }
            else
            {
                rooms[i] = new ACRoom(units);
            }
        }

        double total = 0;

        for (Room room : rooms)
        {
            room.printBill();
            total = total + room.calculateBill();
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}