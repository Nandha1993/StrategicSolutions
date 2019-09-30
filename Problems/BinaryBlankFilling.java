package Problems;

import java.util.Scanner;
/***
 * 
 * Problem : Given B, Binary String 1_0 
      N is 2
      When '_' is replaced by 1's/0's . Find number of times B divisible by N

**/
public class BinaryBlankFilling {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
      int M;
      int N;
      String S;
      while(true) {
        M = sc.nextInt();
        N = sc.nextInt();
        S = sc.next();
        int count = findSolution(M,N,S);
        System.out.println(count);
      }
  }

  private static int findSolution(int m, int n, String s) {
    // TODO Auto-generated method stub
    String binaryInput = s.replace('_', '1');
    int decimal = binaryToDecimal(Integer.parseInt(binaryInput));
    int count = decimal / n;
    if (n % 2 == 0) {
      count =  count -1;
    }
    return count;
  }

  private static int binaryToDecimal(int binaryInput) {
    // TODO Auto-generated method stub
    int binaryNum = binaryInput;
    int base = 1;
    int decimal = 0;
    while(binaryNum > 0) {
      int lastDigit = binaryNum % 10;
      binaryNum = binaryNum / 10;
      decimal += lastDigit * base;
      base*=2;
    }
    return decimal;
  } 

}
