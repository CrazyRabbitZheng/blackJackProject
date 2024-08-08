/**
 * <pre>
 *     Black Jack Game Rules:
 * [Non-Ace] Cards 2-10 are worth the value of the number on the face of the card. Numbered cards are
 * worth the corresponding number indicated on the card. Face cards (those with pictures on them) are
 * worth 10, except for the Ace, which is worth 1 or 11.
 * A picture combined with an Ace is Blackjack (a value of 21).
 * ONLY WHEN YOU HAVE TWO CARDS AND THEY ARE ONE ACE AND OND FACE CARD YOU CALL BLACK JACE
 * The most important blackjack rule is simple: beat the dealer’s hand without going over 21. If you go over
 * 21 you are Bust. If you get 21 points exactly on the deal, that is called a “blackjack.”
 * </pre>
 * @author--Zheng Wang
 */
public class Main {
    public static void main(String[] args) {
        DeckOfCards newDeck = new DeckOfCards();

        System.out.println(newDeck.deal());
        System.out.println(newDeck.deal());
        System.out.println(newDeck.deal());
        System.out.println(newDeck.deal());
    }
}