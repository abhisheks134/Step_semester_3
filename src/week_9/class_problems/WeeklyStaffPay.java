
package week_9.class_problems;

import java.util.Scanner;

abstract class StaffMember
{
    String name;

    StaffMember(String name)
    {
        this.name = name;
    }

    abstract double calculatePay();
}

class FullTimeStaff extends StaffMember
{
    double salary;

    FullTimeStaff(String name, double salary)
    {
        super(name);
        this.salary = salary;
    }

    @Override
    double calculatePay()
    {
        return salary;
    }
}

class HourlyStaff extends StaffMember
{
    double hours;
    double rate;

    HourlyStaff(String name, double hours, double rate)
    {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculatePay()
    {
        if (hours <= 40)
            return hours * rate;

        return 40 * rate + (hours - 40) * rate * 1.5;
    }
}

class InternStaff extends StaffMember
{
    double stipend;

    InternStaff(String name, double stipend)
    {
        super(name);
        this.stipend = stipend;
    }

    @Override
    double calculatePay()
    {
        return stipend;
    }
}

public class WeeklyStaffPay
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        StaffMember[] staff = new StaffMember[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equals("FULLTIME"))
            {
                double salary = scanner.nextDouble();
                staff[i] = new FullTimeStaff(name, salary);
            }
            else if (type.equals("HOURLY"))
            {
                double hours = scanner.nextDouble();
                double rate = scanner.nextDouble();
                staff[i] = new HourlyStaff(name, hours, rate);
            }
            else
            {
                double stipend = scanner.nextDouble();
                staff[i] = new InternStaff(name, stipend);
            }
        }

        double total = 0;

        for (StaffMember member : staff)
        {
            double pay = member.calculatePay();
            System.out.printf("%s: %.2f%n", member.name, pay);
            total += pay;
        }

        System.out.printf("Total Payroll: %.2f%n", total);

        scanner.close();
    }
}
