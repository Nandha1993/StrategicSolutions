package Problems;

import java.util.Scanner;

/**
 * --- Problem Statement --- Given n non-negative integers representing an elevation map where the
 * width of each bar is 1, compute how much water it is able to trap after raining.
 **/

/**
 * 
 * @author Nandha Kumar KR
 *
 */
/**
 * 
 * Input: arr[] = {2, 0, 2} Output: 2 Structure is like below | | |_| We can trap 2 units of water
 * in the middle gap.
 */
public class RainWaterTrapping_SpaceComplexity {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int T;
    int N;
    int arr[];

    T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      N = sc.nextInt();
      arr = new int[N];
      for (int j = 0; j < N; j++) {
        arr[j] = sc.nextInt();
      }
      int waterMeasure = findAmountOfWaterTrapped(arr, N);
      System.out.println(waterMeasure);

    }

  }

  /**
   * 
   * @param arr input array
   * @param n size of array
   * @return totalWaterTrap the result
   */

  /**
   * the idea is to ensure space complexity using the pointer variables and computing the result at
   * a time
   **/
  private static int findAmountOfWaterTrapped(int[] arr, int n) {
    int totalWaterTrap = 0, leftMax = 0, rightMax = 0, leftPointer = 0, rightPointer = n - 1;
    while (leftPointer <= rightPointer) {
      if (arr[leftPointer] < arr[rightPointer]) {
        if (leftMax < arr[leftPointer])
          leftMax = arr[leftPointer];
        else
          totalWaterTrap += leftMax - arr[leftPointer];
        leftPointer++;
      } else {
        if (rightMax < arr[rightPointer])
          rightMax = arr[rightPointer];
        else
          totalWaterTrap += rightMax - arr[rightPointer];
        rightPointer--;
      }
    }

    return totalWaterTrap;
  }
}
