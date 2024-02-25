package Problems;

/**
 * Greedy Algorithm is one of the popular strategy for arriving solutions
 * the idea is simple - it is assuming next immediate as solution
 * i.e deriving solution on each step until the final solution arrives
 */

/**
 * Demonstrating this algorithm approach using a problem :
 * Minimum number of jumps to reach end of the array
 *
 * Examples:
 *
 * Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
 * Output: 3 (1-> 3 -> 8 -> 9)
 * Explanation: Jump from 1st element to 2nd element as there is only 1 step, now there are three options 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.
 *
 * Input : arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
 * Output: 10 Explanation: In every step a jump is needed so the count of jumps is 10.
 *
 */
public class GreedyAlgorithm {


    static int minJumps(int arr[])
    {
        if (arr.length <= 1)
            return 0;

        //If value of first index guarantees
        //only 1 jump is needed, return 1
        if (arr[0] >= arr.length-1)
            return 1;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1)
                return jump;

            if (arr[i] >= (arr.length-1) - i)
                return jump + 1;

            maxReach = Math.max(maxReach, i + arr[i]);

            step--;

            if (step == 0) {
                jump++;
                if (i >= maxReach)
                    return -1;
                step = maxReach - i;
            }
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int arr[] = new int[] { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };

        // calling minJumps method
        System.out.println(minJumps(arr));
    }

}
