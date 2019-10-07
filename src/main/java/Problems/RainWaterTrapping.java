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
 *
 */
public class RainWaterTrapping {

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

  // Solution is finding the leftMost max element and rightmost max element and computing
  // the differnece of min(leftMax, rightMax) and arr[i]

  private static int findAmountOfWaterTrapped(int[] arr, int n) {

    int leftToppestBar[] = new int[n];
    int rightToppestBar[] = new int[n];
    int totalMeasure = 0;
    leftToppestBar[0] = arr[0];
    rightToppestBar[n - 1] = arr[n - 1];

    for (int i = 1; i < n; i++) {
      leftToppestBar[i] = Math.max(leftToppestBar[i - 1], arr[i]);
    }

    for (int i = n - 2; i >= 0; i--) {
      rightToppestBar[i] = Math.max(rightToppestBar[i + 1], arr[i]);
    }


    for (int i = 0; i < n; i++) {
      totalMeasure += Math.min(leftToppestBar[i], rightToppestBar[i]) - arr[i];
    }
    return totalMeasure;
  }

}
