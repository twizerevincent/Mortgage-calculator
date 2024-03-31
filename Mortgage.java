import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final byte PERCENT = 100;
        final byte MONTHS_IN_YEAR = 12;

        Scanner userInput = new Scanner(System.in);

        try {
            System.out.print("Principal Amount: ");
            int principal = userInput.nextInt();

            System.out.print("Annual Interest Rate: ");
            float annualInterestRate = userInput.nextFloat();
            float monthlyInterestRate = (annualInterestRate / PERCENT) / MONTHS_IN_YEAR;

            System.out.print("Period (Years): ");
            int years = userInput.nextInt();
            int period = years * MONTHS_IN_YEAR;

            double mortgage = (principal * (monthlyInterestRate * (Math.pow(1 + monthlyInterestRate, period)))
                    / ((Math.pow(1 + monthlyInterestRate, period)) - 1));

            System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(mortgage));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter numeric values only.");
        } finally {
            userInput.close(); // Close the scanner object
        }
    }
}
