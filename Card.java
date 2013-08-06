/**
* @author Kim Arre
* Card class makes a card as something that has a value and a suit
*/
public class Card {
	int cardValue;
	int suit;

	/**
	* Card constructor makes a new card of a value and a suit
	* @param val The value of the card ranging from 2 to Ace
	* @param st The value of the suit
	*/
	public Card(int val, int st) {
		cardValue = val;
		suit = st;
	}

	/**
	* Changes the suit index to a meaningful suit name
	* @return Returns the string that the suit index corresponds to
	*/
	public String decodeSuit() {
		if(suit == 0) {
			return "of Spades";
		}
		else if(suit == 1) {
			return "of Clubs";
		}
		else if(suit == 2) {
			return "of Diamonds";
		}
		return "of Hearts";
	}

	/**
	* Changes the value index to the corresponding card value from 2 to Ace,
	* including the wildcard for Crazy8's play
	* @return Returns the string that the suit index corresponds to
	*/
	public String decodeValue() {
		//0 1 2 3 4 5 6 7 8   9     10     11    12
		//2 3 4 5 6 7 8 9 10 Jack  Queen  King  Ace

		if(cardValue == -1) {
			return "Wildcard ";
		}
		if(cardValue == 9) {
			return "Jack ";
		}
		else if(cardValue == 10) {
			return "Queen ";
		}
		else if(cardValue == 11) {
			return "King ";
		}
		else if(cardValue == 12) {
			return "Ace ";
		}
		return ((Integer)(cardValue+2)).toString() + " ";
	}

}