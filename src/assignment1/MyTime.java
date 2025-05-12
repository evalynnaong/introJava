package assignment1;

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

    private static int militaryToMinutes(String time){
        int t = Integer.parseInt(time);
        int h = t / 100;
        int m = t % 100;
        return h * 60 + m;
    }

    public static void main(String[] args) {
        printTimeDifference("0300", "0210");

    }
}
