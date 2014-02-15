/**
*BoundedStack interface extends the StackInt to include 
*the size of the stack, its capacity and to check if the
*stack is full
*/

public interface BoundedStack<T> extends StackInt<T>{

    /**
    *Size returns the number of elements currently on the stack
    *@return int value number of items
    */
    public int size();
    
    /**
    *Capacity returns the maximum number of elements the stack can store
    *@return int value max number
    */
    public int capacity();
    
    /**
    *isFull returns true if the number of elements in the stack is equal
    *to the stack capacity, false otherwise
    *@return boolean value true if full, false otherwise
    */
    public boolean isFull();
    
     /**
     * Pushes object x onto the top of the stack.
     * @param x object to be pushed onto the stack.
     * @throws FullStackException if the number of elements on the stack is equal to its capacity
     */
    public void push(T x);
}
