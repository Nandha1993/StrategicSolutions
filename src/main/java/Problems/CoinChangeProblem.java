package Problems;

import java.util.ArrayList;
import java.util.Scanner;

// Problem Statement

/*
 * Coin Change Problem: Given an unlimited supply of coins of given denominations, find the total
 * number of distinct ways to get a desired change... The idea is to use recursion to solve this
 * problem. For each coin of given denominations, we recuse to see if total can be reached by
 * choosing the coin or not...
 */

/*
 * Sample Input 0
 * 
 * 4 3
 * 1 2 3
 */

/*
 * Sample Output
 *  4
 */


public class CoinChangeProblem {

  public static void main(String[] args) {
    int N;
    int m;
    ArrayList<Long> coinsValue = new ArrayList<Long>();
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    m = sc.nextInt();
    for(int i=0; i<m ; i++) {
      coinsValue.add(sc.nextLong());
    }
    int res = findNoOfWays(N,m,coinsValue);
    System.out.println(res);
  }

  /*
   * This problem is solved using dynamic programming paradigm
   *  - simplifying the problem into smaller pieces and arriving the solution
   *  from the next immediate
   */
  private static int findNoOfWays(int n, int m, ArrayList<Long> coinsValue) {
    //purpose of ways array is to determine the number of ways the coins can make value proportional to N.
    long[] ways = new long[n+1];
    // it is clear that there is one way the value will be 0 if no coins.
    ways[0] = 1;
    for(int i=0; i<coinsValue.size();i++) {
      for(int j=0 ; j<ways.length; j++) {
        Long value = new Long(coinsValue.get(i));
        //computations logic
        if(value.intValue()<= j) {
          ways[j] += ways[(int)(j-coinsValue.get(i))];
        }
      }
    }
    return (int)ways[n];
  }

}
