package assignment3;

import java.util.Scanner;

import static assignment3.MyTime.isValidInteger;
import static assignment3.MyTime.printTimeDifference;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean cont = true;

        do {
            try {
                System.out.print("Enter the first time (hhmm): ");
                String time1 = scanner.nextLine();
                if (time1.equals("quit")) {
                    cont = false;
                    System.out.print("Thank you for using our program. Bye!");
                    break;
                }
                isValidInteger(time1);

                System.out.print("Enter the second time (hhmm): ");
                String time2 = scanner.nextLine();
                if (time2.equals("quit")) {
                    cont = false;
                    System.out.print("Thank you for using our program. Bye!");
                    break;
                }
                isValidInteger(time2);


                System.out.print("Time Difference: ");
                printTimeDifference(time1, time2);

                System.out.print("Enter anything to continue or 'quit' to quit: ");
                String answer = scanner.nextLine();

                if (answer.equals("quit")) {
                    System.out.println("Thank you for using our program. Bye!");
                    cont = false;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while(cont);

        scanner.close();
    }
}
