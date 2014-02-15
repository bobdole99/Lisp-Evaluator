import java.util.EmptyStackException;

/**
*BoundStackLinkedList is a linked list implementation of the BoundedStack ADT
*/

public class BoundStackLinkedList<T> implements BoundedStack<T>{

    private Node<T> top;
    private int maxSize;
    private int size;


    /**
    *Constructor sets up a bounded stack with a maximum size of capacity
    */  
    public BoundStackLinkedList (int capacity){
        top = (Node<T>) null;
        size = 0;
        maxSize = capacity;
    }
  
    
    /**
     *Pushes object x onto the top of the stack
     *@param x object to be pushed onto the stack
     *@throws FullStackExcpetion if the stack is full
     */
    public void push(T x) { 
        if (isFull()) throw new FullStackException("full");
        top = new Node<T>(x,top);
        size = size +1;
    }
    
    
     /**
     *top returns the object at the top of the stack
     *@return the item at the top of the stack
     */
    public T top(){
	if (isFull()) throw new FullStackException("full");
	    return top.data;
    }
 
 
     /**
     *pop removes the object at the top of the stack
     *@return reference to the item at the top of the stack
     */
    public T pop() {
        if (isEmpty()) throw new EmptyStackException();
        T x = top.data;
        top = top.next;
        size = size - 1;
        return x;
    }
    
 
    /**
     *Returns the maximum number of elements that the stack can hold
     *@return capacity of the stack (int value)
     */
    public int capacity(){ 
	    return maxSize; 
    }


    /**
    *Size returns the number of elements currently on the stack
    *@return int value number of items
    */
    public int size() { 
	    return size; 
    }


    /**
    *isFull returns true if the number of elements in the stack is equal
    *to the stack capacity, false otherwise
    *@return boolean value true if full, false otherwise
    */
    public boolean isFull() {
	    return (size == maxSize);
    }
    
     /**
     *Checks if the stack is empty.
     *@return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() { 
	    return (size == 0); 
    }
    

    /**
    *Private internal class, instead of writing a seperate class node
    */
    private class Node<T> {
	    private T data;
	    private Node<T> next;

	    private Node(T x, Node<T> n){
	        data = x; 
	        next = n;
	    }
    }  
}
