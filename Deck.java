import java.util.*;

/**
* Deck is a queue of type Card with a shuffle method that randomly 
* rearranges the elements.
* @author Kim Arre
*/
public class Deck extends LQueue {
    LQueue<Card> deckQueue;

    /**
    * Deck constructor makes a new LQueue deck of type Card
    */
    public Deck() {
        deckQueue = new LQueue<Card>();
    }

    /**
    * Makes a shuffled deck by using an ArrayList with all 52 cards in it in order,
    * randomly chooses one of them, removes it, and queues it into the actual
    * new shuffled deck.
    */
    public void shuffle() {
        ArrayList<Card> orderedDeck = new ArrayList<Card>();
        Card transCard;
        int randIndex;
        
        //load up orderedDeck
        for(int i=0; i<4; i++) {        //for each of four suits
            for(int j=0; j<13; j++) {   //for each of 13 card values (2-Ace)
                orderedDeck.add(new Card(j,i));
            }
        }

        while(!(orderedDeck.isEmpty())) {
            //times 10000 (for good measure) because random() returns between 0.0 and 0.1
            randIndex = (int)(Math.random()*10000) % orderedDeck.size();
            transCard = orderedDeck.get(randIndex);
    
            deckQueue.enqueue(transCard);
            orderedDeck.remove(randIndex);
        }
    }

}
