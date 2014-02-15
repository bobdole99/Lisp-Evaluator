import java.util.*;
import java.io.*;
import static java.lang.String.valueOf;
import static java.lang.Double.parseDouble;

public class LispEvaluator {

    /**
    *isValid returns true if str is equal to ), +, -, *, /
    *@param str is the string to check
    *@return true if one of the operators
    */
    public static boolean isValid(String str){
        return (str.equals(")") || str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }
        
    /**
    *Determines whether the first character of the string is a digit
    *@param  str the string for evaluating
    *@return true if the first char is 0 through 9 otherwise return false 
    */
    public static boolean isDigit(String str){
	    return Character.isDigit(str.charAt(0));
    }
  
    /**
    *evaluate, determines the value of the lisp expressions
    *@param finalValue is the value calculated at the end
    *@param stack is the stack data structure
    *@param c is individual string objects that are pused onto the stack
    *@param temp is the temporary value to stored the aritmetic expression
    *@throws InvalidExpressionException if the value is not the expected one
    *@return finalValue final value calculated from the lisp expression
    */ 
    public static double evaluate(String expression) throws InvalidExpressionException{
    	BoundedStack<String> stack = new BoundStackLinkedList<String>(expression.length()); 
        double finalValue = 0;
        
        //left most character must be "("
        if (expression.charAt(0) != '(') throw new InvalidExpressionException ("Invalid Expression");
        
        //read in each character starting at the end of the expression
        int index = expression.length()-1;
        while (index >= 0){

            String c = valueOf(expression.charAt(index));
            index = index - 1;
            
            //if we encounter a digit read the rest of the expression
            if(isDigit(c)){
                String cc = new String();
                if (index >= 0)
                    cc = valueOf(expression.charAt(index));
                while (index >= 0 && isDigit(cc)){
                    c = cc+ c;
                    index = index - 1;
                    if (index >= 0) 
                        cc = valueOf(expression.charAt(index));
                }
            }
            try{

            //push characters onto the stack until we encounter an opening bracket
            if (isValid(c) || isDigit(c))
                stack.push(c);
            else if (c.equals("(")){
                c = (String) stack.pop();
          
            //if we have a valid expression the character on the top
            //of the stack must be an operator followed by 0 or more operands 
            //and a closing bracket
                        
            //if we encounter a plus sign
            if (c.equals("+")){
                double temp = 0;
                c = (String) stack.pop();
                while(!c.equals(")")){
                    temp = temp+ parseDouble(c);
                    c = (String) stack.pop();
                }
                stack.push(valueOf(temp));
            }
            
            //if we encounter a multiply sign
		    else if (c.equals("*")){
		        
		        //temp has to equal 1, mulitply by 0 gives 0
			    double temp = 1;
			    c = (String) stack.pop();
			    while (!c.equals(")")) {
			        temp = temp * parseDouble(c);
			        c = (String) stack.pop();
			    }
			    stack.push(valueOf(temp));
		    }            
                                   
            //if we encounter a minus sign
            else if(c.equals("-")){
                c = (String) stack.pop();
                
                //if we encounter an operator throw exception
                if(isValid(c)) throw new InvalidExpressionException("Invalid Expression");
                double temp = parseDouble(c);
                c = (String) stack.pop();
                
                //if we just encounter a digit with a negative sign number becomes negative
                if(c.equals(")"))
                    temp = -temp;
                else{
                    while(!c.equals(")")){
                        temp = temp - parseDouble(c);
                        c = (String) stack.pop();
                    }
                }
                stack.push(valueOf(temp));
            }
                        
            //if we encounter a division sign
            else if (c.equals("/")){
                c = (String) stack.pop();
                
                //if we encounter an operator throw an exception
                if(isValid(c)) throw new InvalidExpressionException("Invalid Expression");
                double temp = parseDouble(c);
                c = (String) stack.pop();
                
                //if we encounter a digit with a divde sign take is reciprocol
                if(c.equals(")"))
                    temp = 1.0/temp;
                else{
			        while (!c.equals(")")){
				        temp = temp / parseDouble(c);
				        c = (String) stack.pop();
				    }
				}
				stack.push(valueOf(temp));
			}           
		    else throw new InvalidExpressionException("Expected an operand");
            }        
            else if (!c.equals(" "))throw new InvalidExpressionException("Unexpected character c = ");
            }      
            //catch statements
            catch (EmptyStackException e){ 
                throw new InvalidExpressionException("The stack is empty");
            }	
            catch (NumberFormatException e){
                throw new InvalidExpressionException("Not a number");
            }
            catch (ArithmeticException e){
                throw new InvalidExpressionException("Arithmetic error");
            }

            }//end while
        
        
            // if the expression is valid, it should be the onlt entry on the top
            String value = (String) stack.pop();
            if (!stack.isEmpty()) throw new InvalidExpressionException("Not empty at end, stuff still on the stack");

            try {
                finalValue = parseDouble(value);
            }
            //shouldnt ever throw this excpetion
            catch (NumberFormatException e) {
                throw new InvalidExpressionException("Value is not a number");
            }
        return finalValue;
    }
		        
    public static void main(String [] args){
        //get command line arguments, check if valid
        if (args.length != 1){
            System.out.println("Invalid arguments, usage java LispEvaluator <name of file>");
            System.exit(1);
        }
        
        String nameOfFile = args[0];
        FileReader fileRead;
        BufferedReader buffRead;
        
        try{
            fileRead = new FileReader(nameOfFile);
            buffRead = new BufferedReader(fileRead); 
                
            //keep reading until end of the text file
            while(buffRead.ready()){
                String expression = buffRead.readLine();
                try{
                    double value = evaluate(expression);
                    System.out.println(value);
                }
                catch(InvalidExpressionException e){
                    System.out.println("Invalid Expression");
                }            
            }
        }
        catch(FileNotFoundException fnfe){
            System.out.println(fnfe);
            System.exit(0);
        }         
        catch(IOException e){
            System.out.println("There was an error opening the file");
            e.printStackTrace();
        } 
    }
}
