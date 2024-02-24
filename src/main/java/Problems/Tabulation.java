package Problems;

/**
 * Tabulation is the dynamic programming algorithm strategy
 * that mainly to overcome the sub-problem overlapping of recursive function calls
 *
 * The concept is explained using fibonacci series
 */
public class Tabulation {

    public static void main(String[] args) {
        int n =4;
        int fibOfN = computeFibForN(n);
        System.out.println(fibOfN);
    }

    private static int computeFibForN(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2 ; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
