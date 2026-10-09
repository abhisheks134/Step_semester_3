
package week_9.assignment_problems;

import java.util.Scanner;

interface BusUser
{
    double TRANSPORT_FEE = 12000;
}

abstract class Student
{
    String name;

    Student(String name)
    {
        this.name = name;
    }

    abstract double calculateTuition();

    double calculateFee()
    {
        double fee = calculateTuition();

        if (this instanceof BusUser)
            fee += BusUser.TRANSPORT_FEE;

        return fee;
    }
}

class DayScholar extends Student implements BusUser
{
    DayScholar(String name)
    {
        super(name);
    }

    @Override
    double calculateTuition()
    {
        return 40000;
    }
}

class Hosteller extends Student
{
    Hosteller(String name)
    {
        super(name);
    }

    @Override
    double calculateTuition()
    {
        return 40000 + 60000;
    }
}

class Scholar extends Student implements BusUser
{
    Scholar(String name)
    {
        super(name);
    }

    @Override
    double calculateTuition()
    {
        return 20000;
    }
}

public class CollegeFeeCounter
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            String name = scanner.next();

            if (type.equals("DAY_SCHOLAR"))
                students[i] = new DayScholar(name);
            else if (type.equals("HOSTELLER"))
                students[i] = new Hosteller(name);
            else
                students[i] = new Scholar(name);
        }

        double total = 0;

        for (Student student : students)
        {
            double fee = student.calculateFee();
            System.out.printf("%s: %.2f%n", student.name, fee);
            total += fee;
        }

        System.out.printf("Total Collected: %.2f%n", total);

        scanner.close();
    }
}
