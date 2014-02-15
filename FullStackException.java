/**
*FullStackException is used by the bounded stack to indicate an error
when trying to push elements onto a full stack
*/

public class FullStackException extends RuntimeException{
    public FullStackException(String message){
        super(message);
    }
}
