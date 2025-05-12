package assignment3;

public class MyTime {
    public static void printTimeDifference(String time1, String time2) {
        // One option:
        // convert each time to minutes ; make a helper method
        // calculate diff between

        int t1 = militaryToMinutes(time1);
        int t2 = militaryToMinutes(time2);

        int t3;

        if(t1 > t2) {
            t3 = (24 * 60) - (t1-t2);
            //t3 = t1-t2;
        } else {
            t3 = t2 - t1;
        }

        int hours = t3 / 60;
        int minutes = t3 % 60;

        System.out.println( hours + " hour(s) " + minutes + " minute(s)");

    }

    public static int militaryToMinutes(String time){
        int t = Integer.parseInt(time);
        int h = t / 100;
        int m = t % 100;
        return h * 60 + m;
    }

    public static void isValidInteger(String str) {
        if(str == null || str.isEmpty()) { // if its empty fail
            throw new IllegalArgumentException("Please input entry.");
        }
        try {
            if(str.length()>4){
                throw new IllegalArgumentException("Should be 4-digit.Please enter again.");
            }
            int t = Integer.parseInt(str);
            int h = t/100;
            if(h > 23){
                throw new IllegalArgumentException("Hours should be between 0 and 23. Please enter again.");
            }

            int m = t%100;
            if(m > 59){
                throw new IllegalArgumentException("Minutes should be between 0 and 59. Please enter again.");
            }
        } catch(NumberFormatException e) { // if its not an int at all, fail
            throw new IllegalArgumentException("Not a number. Please enter again.");
        }
    }


}
