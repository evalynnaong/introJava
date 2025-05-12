package assignment1;

public class MyCard {
    private String suit;
    private final String UNKNOWN = "Unknown";

    public MyCard(String shorthand) {

        char shortSuit = shorthand.charAt(shorthand.length() -1);

        suit = switch(shortSuit){
            case 'D' -> "Diamonds";
            case 'C' -> "Clubs";
            case 'S' -> "Spades";
            case 'H' -> "Hearts";
            default -> UNKNOWN;

        };
    }

    public String getSuit(){
        return suit;
    }
}
