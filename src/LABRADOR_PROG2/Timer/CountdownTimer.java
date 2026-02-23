package LABRADOR_PROG2.Timer;

import java.util.Timer;
import java.util.TimerTask;

public class CountdownTimer {
    static void main(String[] args) {
//        int seconds = 60; // Set the countdown time in seconds
//
//        System.out.println("Countdown started...");
//
//        for (int i = seconds; i > 0; i--) {
//            System.out.println("Time remaining: " + i + " seconds");
//
//            // Sleep for 1 second (1000 milliseconds)
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Timer was interrupted.");
//                return;
//            }
//        }
//
//        // When the countdown reaches 0, print "Time's up!"
//        System.out.println("Time's up!");


        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int seconds = 60;

            @Override
            public void run() {
                if (seconds > 0) {
                    System.out.println("Time remaining: " + seconds + " seconds");
                    seconds--;
                } else {
                    System.out.println("Time's up!");
                    timer.cancel(); // Stop the timer
                }
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000); // Schedule task to run every second

    }
}
