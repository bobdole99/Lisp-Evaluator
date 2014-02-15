import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;

/** Test suite for LispEvaluator class*/

public class LispTester {
    /**
    *Black Box tests for the evalute function in class LispEvaluator
    */
    
    /*Test case 1
    *Boundary case, tests an invalid expression consisting of a single character "d"
    *Expected result InvalidExpressionException
    */
    @Test (expected = InvalidExpressionException.class)
    public void testSingleChar(){
        String c = new String("d");
	    System.out.println("Testing single value character expression " + c);
	    double value = LispEvaluator.evaluate(c);
	}

    /**Individual operator tests*/
	
	/*Test case 2
	*Boundary case, tests a single operator "+"
	*Expected result InvalidExpressionException
	*/
    @Test (expected = InvalidExpressionException.class)
    public void testSinglePlus(){
        String c = new String("+");
	    System.out.println("Testing single value operator expression " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 3
	*Boundary case, tests a single operator "-"
	*Expected result InvalidExpressionException
	*/
    @Test (expected = InvalidExpressionException.class)
    public void testSingleMinus(){
        String c = new String("-");
	    System.out.println("Testing single value operator expression " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 4
	*Boundary case, tests a single operator "*"
	*Expected result InvalidExpressionException
	*/
    @Test (expected = InvalidExpressionException.class)
    public void testSingleMul(){
        String c = new String("*");
	    System.out.println("Testing single value operator expression " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 5
	*Boundary case, tests a single operator "/"
	*Expected result InvalidExpressionException
	*/
    @Test (expected = InvalidExpressionException.class)
    public void testSingleDiv(){
        String c = new String("/");
	    System.out.println("Testing single value operator expression " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/**Opening and closing bracket tests*/
	
	/*Test case 6
	*Boundary case, tests a single opening bracket
	*Expected result InvalidExpressionException
	*/
    @Test (expected = InvalidExpressionException.class)
    public void testOpeningBracket(){
        String c = new String("(");;
	    System.out.println("Testing single bracket " + c);
	    double value = LispEvaluator.evaluate(c);
    }
    
    /*Test case 7
    *Boundary case, tests a single closing bracket
    *Expected result InvalidExpressionException
    */
    @Test (expected = InvalidExpressionException.class)
    public void testClosingBracket(){
        String c = new String (")");
        System.out.println("Testing single bracket " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 8
	*Boundary case, tests an opening and a closing bracket
	*Expected result InvalidExpressionException
	*/
	@Test (expected = InvalidExpressionException.class)
	public void testOpenClose(){
	    String c = new String("()");
        System.out.println("Testing double bracket " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/**Test operators within single closing and opening brackets*/
	
	/*Test case 9
	*Boundary case, tests a division sign within two brackets
	*Expected result InvalidExpressionException
	*/
	@Test (expected = InvalidExpressionException.class)
	public void testDivWithin(){
	    String c = new String("(/)");
	    System.out.println("Testing single operators within brackets " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 10
	*Boundary case, tests a minus sign within two brackets
	*Expected result InvalidExpressionException
	*/
	@Test (expected = InvalidExpressionException.class)
	public void testMinusWithin(){
	    String c = new String("(-)");
	    System.out.println("Testing single operatos within brackets " + c);
	    double value = LispEvaluator.evaluate(c);
	}
	
	/*Test case 11
	*Boundary case, tests a multiply sign within two brackets
	*Expected result 1.0
	*/
	@Test
	public void testMulWithin(){
	    String c = new String("(*)");
	    System.out.println("Testing single operators within brackets " + c);
	    assertEquals(1.0, LispEvaluator.evaluate(c), 0.001);
	}
	
	/*Test case 12
	*Boundary case, tests a plus sign within two brackets
	*Expected result 0.0
	*/
	@Test
	public void testPlusWithin(){
	    String c = new String("(+)");
	    System.out.println("Testing single operators within brackets " + c);
	    assertEquals(0.0, LispEvaluator.evaluate(c), 0.001);
	}
	
	/**Test single integer with sigle operator*/
	
	/*Test case 13
	*Boundary case, tests plus sign with a single digit 3
	*Expected result 3.0
	*/
	@Test
	public void testPlusInt(){
	    String c = new String("(+ 3)");
	    System.out.println("Test integer with single operator "+ c);
	    assertEquals(3.0, LispEvaluator.evaluate(c), 0.001);
	}	    

	/*Test case 14
	*Boundary case, tests multiply sign with a single digit 7
	*Expected result 7.0
	*/
	@Test
	public void testMulInt(){
	    String c = new String("(* 7)");
	    System.out.println("Test integer with single operator "+ c);
	    assertEquals(7.0, LispEvaluator.evaluate(c), 0.001);
	}
	
	/*Test case 15
	*Boundary case, tests division sign with a single digit 2
	*Expected result 0.5
	*/
	@Test
	public void testDivInt(){
	    String c = new String("(/ 2)");
	    System.out.println("Test integer with single operator "+ c);
	    assertEquals(0.5, LispEvaluator.evaluate(c), 0.001);
	}
	
	/*Test case 16
	*Boundary case, tests minus sign with a single digit 4
	*Expected result -4.0
	*/
	@Test
	public void testMinusInt(){
	    String c = new String("(- 4)");
	    System.out.println("Test integer with single operator "+ c);
	    assertEquals(-4.0, LispEvaluator.evaluate(c), 0.001);
	}
	
	/**Typical test cases for all operators*/
	
	/*Test case 17
	*Typical case, test a plus with integers 3 and 5
	*Expected result 8.0
	*/
	@Test
	public void testTypicalPlus(){
	    String c = new String ("(+ 3 5)");
	    System.out.println("Test for typical case " + c);
	    assertEquals(8.0, LispEvaluator.evaluate(c), 0.001);
	}

	/*Test case 18
	*Typical case, test a minus with integers 5 and 2
	*Expected result 3.0
	*/
	@Test
	public void testTypicalMinus(){
	    String c = new String ("(- 5 2)");
	    System.out.println("Test for typical case " + c);
	    assertEquals(3.0, LispEvaluator.evaluate(c), 0.001);
	}

	/*Test case 19
	*Typical case, test a division with integers 9 and 2
	*Expected result 4.5
	*/
	@Test
	public void testTypicalDivision(){
	    String c = new String ("(/ 9 2)");
	    System.out.println("Test for typical case " + c);
	    assertEquals(4.5, LispEvaluator.evaluate(c), 0.001);
	}

	/*Test case 20
	*Typical case, test a multiply with integers 7 and 4
	*Expected result 28.0
	*/
	@Test
	public void testTypicalMultiply(){
	    String c = new String ("(* 7 4)");
	    System.out.println("Test for typical case " + c);
	    assertEquals(28.0, LispEvaluator.evaluate(c), 0.001);
	}
	
	/** Test some typical complicated tests*/
	
	/*Test case 21
	*Typical case complex test (+ 1 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1))))))))))
	*Expected result 1.414
	*/
    @Test
    public void complexOne(){
        String c = new String("(+ 1 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1 (+ 2 (/ 1))))))))))");
	    System.out.println("Testing complex expression " + c);
        assertEquals(1.414,LispEvaluator.evaluate(c),0.001);
    }
    
	/*Test case 22
	*Typical case complex test (+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1 )))
	*Expected result 16.5
	*/
    @Test
    public void testExample_list(){
        String c = new String("(+ (- 6) (* 2 3 4) (/ (+ 3) (*) (- 2 3 1 )))");
	    System.out.println("Testing complex expression " + c);
        assertEquals(16.5,LispEvaluator.evaluate(c),0.001);
    }
}
