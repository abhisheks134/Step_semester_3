package week_8.class_problems;

class Payment
{
    double amount;

    Payment(double amount)
    {
        this.amount = amount;
    }

    double calculateFee()
    {
        return 0;
    }
}

class CardPayment extends Payment
{
    CardPayment(double amount)
    {
        super(amount);
    }

    @Override
    double calculateFee()
    {
        return amount * 0.02;
    }
}

class WalletPayment extends Payment
{
    WalletPayment(double amount)
    {
        super(amount);
    }

    @Override
    double calculateFee()
    {
        return amount * 0.01;
    }
}

class BankTransferPayment extends Payment
{
    BankTransferPayment(double amount)
    {
        super(amount);
    }

    @Override
    double calculateFee()
    {
        return 0;
    }
}

public class PaymentSystemFeeCalculation
{
    public static void main(String[] args)
    {
        Payment[] payments =
        {
            new CardPayment(1000),
            new WalletPayment(1000),
            new BankTransferPayment(1000)
        };

        for (Payment payment : payments)
        {
            System.out.println("Fee: " + payment.calculateFee());
        }
    }
}