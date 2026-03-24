package Data_Structures_and_Algorithms;

import java.util.Scanner;

public class NoiseDirector {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        IO.print("Enter the number of noise levels: ");
        int numNoiseLevels = scanner.nextInt();

        int[] noises = new int[numNoiseLevels];

        IO.print("Enter the noise level: ");
        for (int i = 0; i < noises.length; i++) {
            noises[i] = scanner.nextInt();
        }

        IO.print("Enter the noise threshold: ");
        int threshold = scanner.nextInt();

        for (int nose : noises) {
            IO.print(nose + ": ");

            checkNoiseLevel(nose, threshold);


            IO.println();
        }
    }

    static void checkNoiseLevel(int noise, int threshold) {
        if (noise <= threshold)
            IO.print("Below Threshold ");
        else
            IO.print("Above Threshold ");
    }

    static int countAboveThreshold(int[] noises, int threshold) {
        int count = 0;
        for (int noise : noises) {
            if (noise > threshold)
                count++;
        }
        return count;
    }
}
