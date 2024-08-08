/**
 * This enum overrides toString method to display numeric values.
 * @author--Zheng Wang
 */
public enum Face {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;

    @Override
    public String toString() {
        String s = "";
        int value = 0;
        switch (this) {
            case ACE: s = " A"; break;
            case TWO: s = " 2"; break;
            case THREE: s = " 3"; break;
            case FOUR: s = " 4"; break;
            case FIVE: s = " 5"; break;
            case SIX: s = " 6"; break;
            case SEVEN: s = " 7"; break;
            case EIGHT: s = " 8"; break;
            case NINE: s = " 9"; break;
            case TEN: s = "10"; break;
            case JACK: s = " J"; break;
            case QUEEN: s = " Q"; break;
            case KING: s = " K"; break;
        }
        return s;
    }
}


