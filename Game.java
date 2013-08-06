import java.util.*;
/**
* Game creates a deck, as well as ArrayLists for the players hands to conduct
* a game of Crazy8's.
* @author Kim Arre
*/
public class Game {
	public static void main(String[] args) {
		
		Deck gameDeck = new Deck();
		gameDeck.shuffle();
		Scanner scan = new Scanner(System.in);
		ArrayList<Card> compHand = new ArrayList<Card>();
		ArrayList<Card> playerHand = new ArrayList<Card>();
		Card topCard;
		int choice=-3, suitChoice; //initialized to -3 just as an unreachable check
		boolean intChoice = false;
		
		//initial deal of 8 cards per player
		for(int i=0; i<8; i++) {
			compHand.add(gameDeck.deckQueue.dequeue());
			playerHand.add(gameDeck.deckQueue.dequeue());
		}
		topCard = gameDeck.deckQueue.dequeue();

		System.out.println("\nCrazy 8's. 'SKO.");

		while(!gameDeck.deckQueue.isEmpty() && !playerHand.isEmpty() && !compHand.isEmpty()) {

			intChoice = false;

			System.out.println("\nHere's your hand:\n");
			for(int i=0; i<playerHand.size(); i++) {
				Card tempCard = playerHand.get(i);
				System.out.println("   " + (i+1) + ". " + tempCard.decodeValue() + tempCard.decodeSuit());
			}

			System.out.println("\nTop Card: " + topCard.decodeValue() + topCard.decodeSuit());

			System.out.println("\nSelect corresponding card number to play a card, or 0 to draw from the deck.");
			
			System.out.print("Your Choice: ");	
			if(scan.hasNextInt()) {
				intChoice = true;
				choice = scan.nextInt();
			}

			//if invalid choice
			while(intChoice == false || choice > playerHand.size()) {
				scan.nextLine();
				System.out.print("Not a valid choice. Choose again: ");
				if(scan.hasNextInt()) {
					intChoice = true;
					choice = scan.nextInt();
				}
			}

			//if card is not a valid play
			// "cardValue != 6" to check if it's an 8
			while(choice != -1 && choice != 0 && playerHand.get(choice-1).cardValue != 6 && playerHand.get(choice-1).suit != topCard.suit && playerHand.get(choice-1).cardValue != topCard.cardValue) {
				scan.nextLine();
				System.out.print("You can't play that. Choose again: ");
				choice = scan.nextInt();
			}

			System.out.println("-----------------------------------");

			//if the card is an 8
			if(choice !=0 && choice != -1 && playerHand.get(choice-1).cardValue == 6) {
				scan.nextLine();
				System.out.println("\nYou played a Crazy 8.");
				System.out.println("    1. Hearts");
				System.out.println("    2. Diamonds");
				System.out.println("    3. Clubs");
				System.out.println("    4. Spades");
				System.out.print("Which suit would you like? ");
				suitChoice = scan.nextInt();

				//the suit values correspond to what they're assigned to in decodeSuit()
				// -1 to ensure it can't be matched on next play
				if(suitChoice == 1) {
					topCard = new Card(-1, 3);
				}
				else if(suitChoice == 2) {
					topCard = new Card(-1, 2);
				}
				else if(suitChoice == 3) {
					topCard = new Card(-1, 1);
				}
				else {
					topCard = new Card(-1, 0);
				}
				playerHand.remove(choice-1);
				System.out.println("-----------------------------------");
			}

			else if(choice != -1 && choice != 0) {
				topCard = playerHand.get(choice-1);
				playerHand.remove(choice-1);
			}
			else if(choice == -1) {
				topCard = playerHand.get(0);
				playerHand.remove(0);
			}
			else if(choice == 0) {
				playerHand.add(gameDeck.deckQueue.dequeue());
			}

			//if player plays their last card
			if(playerHand.isEmpty()) {
				break;
			}

			System.out.println("\nTop Card: " + topCard.decodeValue() + topCard.decodeSuit());

			if(!gameDeck.deckQueue.isEmpty()) {
				// ----- Start of Computer turn -----
				boolean compHasPlayed = false;
				for(int i=0; i<compHand.size(); i++) {
					if(compHand.get(i).suit == topCard.suit || compHand.get(i).cardValue == topCard.cardValue) {
						topCard = compHand.get(i);
						compHand.remove(i);
						compHasPlayed = true;
						System.out.println("\nThe computer has played a card. The computer now has " + compHand.size() + " cards.\n");
						break;
					}
				}

				//computer didn't have anything to play, must draw
				if (compHasPlayed == false) {
					compHand.add(gameDeck.deckQueue.dequeue());
					System.out.println("\nThe computer has drawn a card. The computer now has " + compHand.size() + " cards.\n");
				}
				

				System.out.println("-----------------------------------");
			}
			
		}

		//Winning checks
		if(gameDeck.deckQueue.isEmpty()){
			System.out.println("\nCard deck is empty. It's a tie!\n");
		}
		else if(playerHand.isEmpty()) {
			System.out.println("\nYou win! No cards left in your hand. :D");
			System.out.println("\nHave a congratulatory kitteh!\n");
			congratKitteh();
		}
		else if(compHand.isEmpty()) {
			System.out.println("\nComputer wins. No cards left in the computer's hand. You lose. :'(\n");
		}

	}
	/**
	* For added incentive. And because it makes me smile. Hopefully it does for
	* you, as well.
	*/
	public static void congratKitteh() {
		System.out.println("                   ,_     _            ");
		System.out.println("                   |\\\\_,-~/          ");
		System.out.println("                   / _  _ |    ,--.    ");
		System.out.println("       Mrow. :)   (  @  @ )   / ,-'    ");
		System.out.println("                   \\  _T_/-._( (      ");
		System.out.println("                   /         `. \\     ");
		System.out.println("                  |         _  \\ |    ");
		System.out.println("                   \\ \\ ,  /      |   ");
		System.out.println("                    || |-_\\__   /     ");
		System.out.println("                   ((_/`(____,-'       \n");
	}

}