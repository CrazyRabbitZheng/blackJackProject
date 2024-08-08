/**
 * This class creates and shuffles the new deck of cards.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<Card> list;

    /**
     * constructor
     */
    public DeckOfCards() {
        Card[] deck = new Card[52];
        int count = 0;

        for(Suit suit : Suit.values()){
            for(Face face : Face.values()){
                deck[count] = new Card(suit, face);
                count++;
            }
        }

        list = Arrays.asList(deck);
        Collections.shuffle(list);
    }

    int currentCard = 0;

    /**
     *
     * @return Card
     */
    public Card deal(){
        if(currentCard < list.size()){
            return list.get(currentCard++);
        }else return null;
    }
}
