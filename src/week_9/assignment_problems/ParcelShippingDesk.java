
package week_9.assignment_problems;

import java.util.Scanner;

abstract class Parcel
{
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue)
    {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance()
    {
        return 0;
    }

    double calculateTotal()
    {
        return calculateCharge() + calculateInsurance();
    }
}

class StandardParcel extends Parcel
{
    StandardParcel(double weight, double declaredValue)
    {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge()
    {
        return 40 + 10 * weight;
    }
}

class ExpressParcel extends Parcel
{
    ExpressParcel(double weight, double declaredValue)
    {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge()
    {
        return 80 + 15 * weight;
    }

    @Override
    double calculateInsurance()
    {
        return declaredValue * 0.02;
    }
}

class FragileParcel extends Parcel
{
    FragileParcel(double weight, double declaredValue)
    {
        super(weight, declaredValue);
    }

    @Override
    double calculateCharge()
    {
        return 40 + 10 * weight + 50;
    }

    @Override
    double calculateInsurance()
    {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDesk
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Parcel[] parcels = new Parcel[n];
        String[] types = new String[n];

        for (int i = 0; i < n; i++)
        {
            types[i] = scanner.next();
            double weight = scanner.nextDouble();
            double value = scanner.nextDouble();

            if (types[i].equals("STANDARD"))
                parcels[i] = new StandardParcel(weight, value);
            else if (types[i].equals("EXPRESS"))
                parcels[i] = new ExpressParcel(weight, value);
            else
                parcels[i] = new FragileParcel(weight, value);
        }

        double grandTotal = 0;

        for (int i = 0; i < n; i++)
        {
            Parcel parcel = parcels[i];
            double charge = parcel.calculateCharge();
            double insurance = parcel.calculateInsurance();
            double total = parcel.calculateTotal();

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                types[i], charge, insurance, total
            );

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);

        scanner.close();
    }
}
