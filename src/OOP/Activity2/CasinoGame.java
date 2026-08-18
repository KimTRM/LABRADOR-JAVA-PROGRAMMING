package OOP.Activity2;

import java.util.Random;
import java.util.Scanner;

public class CasinoGame {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static void main() {
        IO.println("Welcome to the Casino Game!");

        IO.print("Enter your starting money: ");
        int startingBalance = scanner.nextInt();
        int balance = startingBalance;

        while (true) {
            IO.println("\nCurrent Balance: " + balance);

            int bet = getBetMoney(balance);
            int num = getBetNum();

            balance = determineWinner(num, generateRandomNumber(), bet, balance);

            IO.println("\nCurrent Balance: " + balance);

            if (playAnotherRound()) {
                IO.println("\nThank you for playing!");
                IO.println("Final Balance: " + balance);
                IO.println("Starting Balance: " + startingBalance);

                break;
            }
        }
    }

    static int getBetMoney(int balance) {
        int bet;
        while (true) {
            IO.print("Enter your bet: ");
            bet = scanner.nextInt();
            if (bet > 0 && bet <= balance) {
                break;
            } else {
                IO.println("Invalid bet amount. Please enter a positive number less than or equal to your current balance.");
            }
        }
        return bet;
    }

    static int getBetNum() {
        int number;
        while (true) {
            IO.print("Enter a number (1-6): ");
            number = scanner.nextInt();
            if (number >= 1 && number <= 6) {
                break;
            } else {
                IO.println("Invalid input. Please enter a number between 1 and 6.");
            }
        }
        return number;
    }

    static int generateRandomNumber() {
        return random.nextInt(6) + 1;
    }

    static int determineWinner(int num, int generatedNumber, int bet, int balance) {
        if (generatedNumber == num) {
            int winnings = bet * 3;
            balance += winnings;

            IO.println("\nCongratulations! You won!");
            IO.println("You earned: " + winnings);
        } else {
            balance -= bet;

            IO.println("\nSorry, you lost " + bet);
        }

        return balance;
    }

    static boolean playAnotherRound() {
        IO.println("Play again? (Y/N): ");
        String choice = scanner.next();

        return choice.equalsIgnoreCase("N");
    }
}
