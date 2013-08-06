import java.util.*;

/**
 * LQueue when initialized creates an empty queue using a linked list with
 * front and end nodes as instance variables.
 * @author Kim Arre
 */

public class LQueue<T> {
    private Node front;
    private Node end;

    //Constructor creates an empty queue
    public LQueue() {
        front = null;
        end = null;
    }

    //Initializes a Node for the linked list queue
    private class Node {
        public T elem;
        public Node next;

        Node(T data, Node n) {
            elem = data;
            next = n;
        }
    }

    /** 
    * Prints reasons for exceptions being thrown for errors.
    */
    public static class MyException extends RuntimeException {
        public MyException() {
            System.out.println("Something went wrong.");
        }

        public MyException(String e) {
            System.out.println(e);
        }
    }

    /** 
     * Adds an element to the end of the queue.
     * @param data the information that is to be put into the Node to enqueue
     */
    public void enqueue(T data) {
        Node newN = new Node(data, null);

        if(isEmpty()) {
            //If no other elements, new node will be front and end of the queue
            front = newN;
            end = newN;
        }
        else {
            end.next = newN;
            end = newN;
        }

    }

    /** 
     * Dequeues and returns the front element of the queue.
     * @return the Node that is at the front of the queue
     * @throws MyException throws when the list is empty
     */
    public T dequeue() {
        Node temp;

        if(isEmpty()) {
            throw new MyException("List is empty. Cannot dequeue.");
        }

        temp = front;
        front = front.next;

        return temp.elem;
    }

    /** 
    * Checks to see if the queue is empty.
    * @return a boolean answer for whether or not queue is empty
    */
    public boolean isEmpty() {
        return (front == null);
    }


}