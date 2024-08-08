/**
 * This enum overrides toString method to display ♥ ♦ ♣ ♠ as suits
 * @author--Zheng Wang
 */
public enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES;

    @Override
    public String toString() {
        String s = "";
        switch (this) {
            case HEARTS: s = "♥"; break;
            case DIAMONDS: s = "♦"; break;
            case CLUBS: s = "♣"; break;
            case SPADES: s = "♠"; break;
        }
        return s;
    }
}
