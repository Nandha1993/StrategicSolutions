package Problems;

import java.util.Scanner;

public class RecursiveSolutions {

  public static void main(String[] args) {
  
    Scanner sc = new Scanner(System.in);
    int inputNumber = sc.nextInt();
    boolean prime = true;
    prime = isPrime(inputNumber,2);
    System.out.println(prime?"Prime Number": "Not a Prime Number");
    int fibonacci = fibonacciDynamicProgrammingSolution(inputNumber);
    System.out.println("fibonacci :"+ fibonacci);
    int factorialUsingRecursion = factorialUsingRecursion(inputNumber);
    System.out.println("Factorial :"+ factorialUsingRecursion);

  }

  //prime number - recursion
  private static boolean isPrime(int n, int i) {
  
    if(n<=2) {
      return (n == 2)? true: false;
    }
    if(n % i == 0) {
      return false;
    }
    if(i*i > n) {
      return true;
    }
    return isPrime(n, i+1);
  }
  
  //Fibonacci Series - recursion
  private static int fibonacciSeries(int n) { 
    
    if(n<=1) {
      return n;
    }
    int fib = fibonacciSeries(n-2)+fibonacciSeries(n-1);
    System.out.println(fib);
    return fib;
  }
  
  //Fibonacci Series Dynamic Programming
  private static int fibonacciDynamicProgrammingSolution(int n) {
    
    int fib0 = 0, fib1=1;
    int fib = 0;
    int i= 2;
    
    if(n<=1) {
      return (n==0)?0:1;
    }
    while(i<n) {     
      fib = fib0 + fib1;
      fib0 = fib1;
      fib1 = fib;
      i++;
    }
    return fib;
  }
  
  //Factorial using recursion
  private static int factorialUsingRecursion(int n) {
    
    int fact = 1;
   
    if(n<=2) {
      return (n==2)?2:1;
    }
    if(n!=0) {
      fact = n* factorialUsingRecursion(--n);
    }
    return fact;
  }

}

