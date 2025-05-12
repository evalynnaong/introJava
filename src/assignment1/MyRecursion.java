package assignment1;

public class MyRecursion {
    public static int indexOf(String a, String b) {
        int match;
        match = indexOfHelper(a, 0, b, 0);
        return match;
    }

    public static int indexOfHelper(String a, int i, String b, int j) {
        if(j == b.length()){
            return i - j;
        } // base case reached end of string b
        else if(i == a.length()){ // fail case reached end of string a w/o end of b
            return -1;
        } else if(a.charAt(i) == b.charAt(j)){
            i++;
            j++;
            return indexOfHelper(a, i, b, j);
        } else if(a.charAt(i) != b.charAt(j)){
            if(j != 0) {
                j = 0;
                return indexOfHelper(a, i, b, j);
            } else {
                j = 0;
                i++;
                return indexOfHelper(a, i, b, j);
            }
        }
        return 0;
    }

    /*public static void main(String[] args) {
        String a = "Mississippi" ;
        String b = "sip";

        int test = indexOf(a,b);
        System.out.println(test);
    }*/
}
