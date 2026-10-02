package week_8.assignment_problems;

import java.util.Scanner;

class Customer
{
    String type;
    double amount;

    Customer(String type, double amount)
    {
        this.type = type;
        this.amount = amount;
    }

    double calculateFinalAmount()
    {
        return amount;
    }

    void printBill()
    {
        System.out.printf("%s: %.2f%n", type, calculateFinalAmount());
    }
}

class Student extends Customer
{
    Student(double amount)
    {
        super("STUDENT", amount);
    }

    @Override
    double calculateFinalAmount()
    {
        return amount * 0.90;
    }
}

class Staff extends Customer
{
    Staff(double amount)
    {
        super("STAFF", amount);
    }

    @Override
    double calculateFinalAmount()
    {
        return amount * 0.95;
    }
}

class Guest extends Customer
{
    Guest(double amount)
    {
        super("GUEST", amount);
    }

    @Override
    double calculateFinalAmount()
    {
        return amount + 10;
    }
}

public class CanteenBillingCounter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Customer[] customers = new Customer[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            double amount = scanner.nextDouble();

            if (type.equals("STUDENT"))
            {
                customers[i] = new Student(amount);
            }
            else if (type.equals("STAFF"))
            {
                customers[i] = new Staff(amount);
            }
            else
            {
                customers[i] = new Guest(amount);
            }
        }

        double total = 0;

        for (Customer customer : customers)
        {
            customer.printBill();
            total = total + customer.calculateFinalAmount();
        }

        System.out.printf("Total: %.2f%n", total);

        scanner.close();
    }
}