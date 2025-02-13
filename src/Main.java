import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;
        int principal = 0;
        float monthlyInterestRate = 0;
        int numberOfPayments = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal:");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }
        while (true) {

            System.out.print("Annual Interest Rate:");
            float annualInterestRate = scanner.nextFloat();
            if (annualInterestRate >= 1 && annualInterestRate <= 30) {
                monthlyInterestRate = annualInterestRate / PERCENTAGE / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while (true) {

            System.out.print("Period(Years):");
            byte years = scanner.nextByte();
            if(years>=1 && years<=30){
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
            double mortage = principal
                    * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments))
                    / Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1;

            String mortageFormatted = NumberFormat.getCurrencyInstance(Locale.US).format(mortage);
            System.out.print("Mortage:" + mortageFormatted);
        }
    }