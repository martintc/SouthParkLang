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
     String token = scan.next();
     // check for each kind of token
     // if token is an opertor then push to operator stack
     // if token is an operand, this push to operand stack
     // if right perenthesis, evaluate operands against operator
     // restart loop
   }
    
  }
  
}
