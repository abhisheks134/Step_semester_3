package week_8.class_problems;

class Delivery
{
    double weight;
    double distance;

    Delivery(double weight, double distance)
    {
        this.weight = weight;
        this.distance = distance;
    }

    double calculateFee()
    {
        return 0;
    }
}

class StandardDelivery extends Delivery
{
    StandardDelivery(double weight, double distance)
    {
        super(weight, distance);
    }

    @Override
    double calculateFee()
    {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }
}

class ExpressDelivery extends Delivery
{
    ExpressDelivery(double weight, double distance)
    {
        super(weight, distance);
    }

    @Override
    double calculateFee()
    {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }
}

class InternationalDelivery extends Delivery
{
    double customsFee;

    InternationalDelivery(double weight, double distance, double customsFee)
    {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    double calculateFee()
    {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }
}

public class DeliveryFeeCalculator
{
    public static void main(String[] args)
    {
        Delivery[] deliveries =
        {
            new StandardDelivery(10, 20),
            new ExpressDelivery(10, 20),
            new InternationalDelivery(10, 20, 15)
        };

        double total = 0;

        for (Delivery delivery : deliveries)
        {
            double fee = delivery.calculateFee();

            System.out.println("Delivery Fee: $" + fee);

            total = total + fee;
        }

        System.out.println("Total Fee: $" + total);
    }
}
