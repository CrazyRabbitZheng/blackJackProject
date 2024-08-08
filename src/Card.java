/**
 * <pre>
 *     * * * * * * *
 *     *10♥        *
 *     *           *
 *     *           *
 *     *     ♥     *
 *     *           *
 *     *           *
 *     *        ♥10*
 *     * * * * * * *
 *
 *     * * * * * * *
 *     * A♠        *
 *     *           *
 *     *           *
 *     *     ♠     *
 *     *           *
 *     *           *
 *     *        ♠ A*
 *     * * * * * * *
 * </pre>
 * This class displays cards as shown above.
 * It gives enum Face values to assist the BlackJackSimulator class calculating the value of cards.
 * @author--Zheng Wang
 */
public class Card {
    private final Suit suit;
    private final Face face;

    /**
     * Constructor
     * @param suit
     * @param face
     */
    public Card(Suit suit, Face face) {
        this.suit = suit;
        this.face = face;
    }

    /**
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     *
     * @return face
     */
    public Face getFace() {
        return face;
    }

    @Override
    public String toString() {
        return String.format("* * * * * * *%n*%s%s   %3$6s%n*     %3$7s%n*     %3$7s%n*  %2$4s  %3$4s%n*     %3$7s%n*     %3$7s%n*   %2$6s%1$s*%n* * * * * * *%n",
                face,suit,"*");
    }

    /**
     *
     * @return value
     */
    public int getValue(){
        int value = 0;
        switch (this.face) {
            case ACE: value = 11; break;
            case TWO: value = 2; break;
            case THREE:  value = 3; break;
            case FOUR: value = 4; break;
            case FIVE: value = 5; break;
            case SIX: value = 6; break;
            case SEVEN: value = 7; break;
            case EIGHT: value = 8; break;
            case NINE: value = 9; break;
            case TEN: value = 10; break;
            case JACK: value = 10; break;
            case QUEEN: value = 10; break;
            case KING: value = 10; break;
        }
        return value;
    }
}
