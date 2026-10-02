package week_8.assignment_problems;

import java.util.Scanner;

class Employee
{
    String name;
    double salary;

    Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    double calculateBonus()
    {
        return 0;
    }

    void printBonus()
    {
        System.out.printf("%s: %.2f%n", name, calculateBonus());
    }
}

class FullTimeEmployee extends Employee
{
    FullTimeEmployee(String name, double salary)
    {
        super(name, salary);
    }

    @Override
    double calculateBonus()
    {
        return salary * 0.10;
    }
}

class PartTimeEmployee extends Employee
{
    PartTimeEmployee(String name, double salary)
    {
        super(name, salary);
    }

    @Override
    double calculateBonus()
    {
        return salary * 0.05;
    }
}

class Intern extends Employee
{
    Intern(String name, double salary)
    {
        super(name, salary);
    }

    @Override
    double calculateBonus()
    {
        return 2000;
    }
}

public class FestivalBonusCalculator
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            String name = scanner.next();
            double salary = scanner.nextDouble();

            if (type.equals("FULLTIME"))
            {
                employees[i] = new FullTimeEmployee(name, salary);
            }
            else if (type.equals("PARTTIME"))
            {
                employees[i] = new PartTimeEmployee(name, salary);
            }
            else
            {
                employees[i] = new Intern(name, salary);
            }
        }

        double totalBonus = 0;

        for (Employee employee : employees)
        {
            employee.printBonus();
            totalBonus = totalBonus + employee.calculateBonus();
        }

        System.out.printf("Total Bonus: %.2f%n", totalBonus);

        scanner.close();
    }
}