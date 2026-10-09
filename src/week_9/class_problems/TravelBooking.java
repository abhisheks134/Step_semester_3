
package week_9.class_problems;

import java.util.Scanner;

abstract class Booking
{
    double distance;
    static final double BOOKING_FEE = 50;

    Booking(double distance)
    {
        this.distance = distance;
    }

    abstract double calculateBaseFare();

    double calculateTotal()
    {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking
{
    BusBooking(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return distance * 2;
    }
}

class TrainBooking extends Booking
{
    TrainBooking(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return distance * 1.5;
    }
}

class FlightBooking extends Booking
{
    FlightBooking(double distance)
    {
        super(distance);
    }

    @Override
    double calculateBaseFare()
    {
        return 2500 + distance * 4;
    }
}

public class TravelBooking
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Booking[] bookings = new Booking[n];

        for (int i = 0; i < n; i++)
        {
            String mode = scanner.next();
            double distance = scanner.nextDouble();

            if (mode.equals("BUS"))
                bookings[i] = new BusBooking(distance);
            else if (mode.equals("TRAIN"))
                bookings[i] = new TrainBooking(distance);
            else
                bookings[i] = new FlightBooking(distance);
        }

        for (Booking booking : bookings)
        {
            System.out.printf("%s: %.2f%n",
                    booking.getClass().getSimpleName()
                            .replace("Booking", "").toUpperCase(),
                    booking.calculateTotal());
        }

        scanner.close();
    }
}

