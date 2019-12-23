import java.util.Stack;
import java.util.Scanner;

public class Interpreter {
  
  private Stack<Operator> operators;
  private Stack<Operands> operands;
  private Scanner scan;
  
  public Interpreter () {
           operators = new Stack<>();
           operands = new Stack<>();
           scan = new Scanner(System.in);
  }
  
  public void parseFile () {
    
   while(scan.hasNextLine()) {
     
   }
    
  }
  
}
