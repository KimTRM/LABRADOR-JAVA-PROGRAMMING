package Grade11.decesion_structure;

import java.util.Scanner;

public class Time_Calculator {

	public static void main(String[] args) {
		int seconds,minutes,hours,days;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of seconds:");
		seconds = input.nextInt();
		
		if (seconds < 3600) {
           minutes = seconds / 60;
		   seconds %= 60;
           System.out.print("output: " + minutes + " minutes, " + seconds + " seconds ");
		                   
		}else if (seconds < 86400) {
			hours = seconds / 3600;
			minutes = seconds / 60;
			minutes %= 60;
			seconds %= 60;
           System.out.print("output: " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds ");
           
		}else if (seconds >= 86400) {
			days = seconds / 86400;
			hours = seconds / 3600;
			hours %= 24;
			minutes = seconds / 60;
			minutes %= 60;
			seconds %= 60;
           System.out.print("output: " + days + " days, " + hours + " hours, " + minutes + " minutes, " + seconds + " seconds ");
		}
   
		
    }
}




