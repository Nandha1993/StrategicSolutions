package Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SuperStack {

  public static void main(String[] args)  {
    Scanner in = new Scanner(System.in);
    int operations_size = 0;
    operations_size = Integer.parseInt(in.nextLine().trim());

    String[] operations = new String[operations_size];
    for(int i = 0; i < operations_size; i++) {
        String operations_item;
        try {
            operations_item = in.nextLine();
        } catch (Exception e) {
            operations_item = null;
        }
        operations[i] = operations_item;
    }

    superStack(operations);
    
}

  private static void superStack(String[] operations) {
    List<Integer> stackList = new ArrayList<Integer>();
    for (String operation : operations) {
      if (operation.startsWith("push")) {
        push(Integer.parseInt(operation.substring(5)), stackList); 
      }
      else if (operation.startsWith("pop")) {
        pop(stackList); 
      } else if (operation.startsWith("inc")) {
        int i = Integer.parseInt(operation.split(" ")[1]);
        int j = Integer.parseInt(operation.split(" ")[2]);
        inc(i,j , stackList);
      }
    }
  }

  private static void inc(int i, int j, List<Integer> stackList) {
    for(int k= 0 ; k<i ; k++) {
      stackList.set(k, stackList.get(k)+j);
    }
    System.out.println(stackList.get(stackList.size()-1));
  }

  private static void pop(List<Integer> stackList) {
    if (stackList.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      stackList.remove(stackList.size()-1);
      System.out.println(stackList.get(stackList.size()-1));
    }
    
  }

  private static void push(int item, List<Integer> stack) {
    stack.add(item);
    System.out.println(stack.get(stack.size()-1));
  }
}
