package Grade11.simplegame;

import java.util.Scanner;

public class question {

    static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int lives = 3;
        String answer;

        while (lives > 0) {

            System.out.println("The Sun is also called as?");
            System.out.println("Your answer is; ");

            answer = s.nextLine();

            if (answer.equalsIgnoreCase("Sol")) break;
            else
                lives--;

            if (lives < 1)
                System.out.println("You have used all the attemps");
            else
                System.out.println("Wrong answer, try again\n");

        }
        if (lives > 0) System.out.println("Correct Answer!!");
        else System.out.println("You Lost");
    }
}
