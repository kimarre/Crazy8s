import java.util.*;

/**
 * This is the testing driver to ensure the LQueue class is properly made
 * @author Kim Arre
 */
public class LQueueDriver {
	public static void main(String[] args) {
		LQueue<Integer> queueObject = new LQueue<Integer>();
		boolean dontQuit = true;
		boolean empty;
		Scanner scan = new Scanner(System.in);
		char choice;
		Integer taken, enqueued;


		// Menu Options
		System.out.println("\nChoose one of the following operations:");
		System.out.println("-enqueue/add (enter the letter a)");
		System.out.println("-dequeue/delete (enter the letter d)");
		System.out.println("-check if the list is empty (enter the letter e)");
		System.out.println("quit (enter the letter q)\n");
		

		while(dontQuit) {
			System.out.print(">> ");
			choice = scan.nextLine().charAt(0);

			if(choice == 'q') {
				dontQuit = false;
				continue;
			}

			//User wants to enqueue
			if(choice == 'a') {
				System.out.print("Enter an Integer to enqueue/add: ");
				//ensures that the scann
				if(scan.hasNextInt()) {
					enqueued = scan.nextInt();
					queueObject.enqueue(enqueued);
					System.out.println("enqueued " + enqueued);
					scan.nextLine();
				}
				else {
					System.out.println("Not an integer. Did not enqueue.");
				}
				continue;
			}

			// User wants to dequeue
			if(choice == 'd') {
				taken = queueObject.dequeue();
				System.out.println("dequeued " + taken);
				continue;
			}

			// User wants to check if empty
			if(choice == 'e') {
				empty = queueObject.isEmpty();
				if(empty) {
					System.out.println("queue is empty");
				}
				else {
					System.out.println("queue is not empty");
				}
				continue;
			}
			else {
				System.out.println("Not a valid menu choice.");
				continue;
			}
			
		}
	}
}