echo Compiling... 
javac BoundedStack.java
javac BoundStackLinkedList.java
javac FullStackException.java
javac InvalidExpressionException.java
javac LispEvaluator.java
javac StackInt.java
echo Testing ...
javac -cp ".:junit-4.8.2.jar" LispTester.java
java -cp ".:junit-4.8.2.jar" org.junit.runner.JUnitCore LispTester
echo Done
