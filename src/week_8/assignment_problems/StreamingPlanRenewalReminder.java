package week_8.assignment_problems;

import java.time.LocalDate;
import java.util.Scanner;

class SubscriptionPlan
{
    String name;
    LocalDate startDate;

    SubscriptionPlan(String name, LocalDate startDate)
    {
        this.name = name;
        this.startDate = startDate;
    }

    LocalDate calculateRenewalDate()
    {
        return startDate;
    }

    void printRenewalDate()
    {
        System.out.println(name + ": " + calculateRenewalDate());
    }
}

class BasicPlan extends SubscriptionPlan
{
    BasicPlan(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan
{
    StandardPlan(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan
{
    PremiumPlan(String name, LocalDate startDate)
    {
        super(name, startDate);
    }

    @Override
    LocalDate calculateRenewalDate()
    {
        return startDate.plusDays(365);
    }
}

public class StreamingPlanRenewalReminder
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        SubscriptionPlan[] plans = new SubscriptionPlan[n];

        for (int i = 0; i < n; i++)
        {
            String type = scanner.next();
            String name = scanner.next();
            LocalDate startDate = LocalDate.parse(scanner.next());

            if (type.equals("BASIC"))
            {
                plans[i] = new BasicPlan(name, startDate);
            }
            else if (type.equals("STANDARD"))
            {
                plans[i] = new StandardPlan(name, startDate);
            }
            else
            {
                plans[i] = new PremiumPlan(name, startDate);
            }
        }

        for (SubscriptionPlan plan : plans)
        {
            plan.printRenewalDate();
        }

        scanner.close();
    }
}