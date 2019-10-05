package Problems;

import java.util.Arrays;
import java.util.Scanner;

public class RainWaterHarvesting {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner(System.in);
    int T;
    int N;
    int arr[];
    
    T = sc.nextInt();
    for(int i=0; i<T; i++) {
      N = sc.nextInt();
      arr = new int[N];
      for(int j=0 ;j<N; j++) {
        arr[j] = sc.nextInt();
      }
      int waterMeasure = findAmountOfWaterTrapped(arr, N);
      System.out.println(waterMeasure);
    }
    

  }

  private static int findAmountOfWaterTrapped(int[] arr, int n) {
    
    int leftToppestBar[] = new int[n];
    int rightToppestBar[] = new int[n];
    int totalMeasure = 0;
    leftToppestBar[0] = arr[0];
    rightToppestBar[n-1] = arr[n-1];
    
    for(int i=1; i<n; i++) {
      leftToppestBar[i] = Math.max(leftToppestBar[i-1], arr[i]);
    }
    
    for(int i= n-2 ; i>=0; i--) {
      rightToppestBar[i] = Math.max(rightToppestBar[i+1], arr[i]);
    } 
   
    
    for(int i= 0; i<n; i++) {
      totalMeasure+= Math.min(leftToppestBar[i], rightToppestBar[i]) - arr[i];
    }   
    return totalMeasure;
  }

}
