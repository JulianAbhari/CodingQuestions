import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ArrayList<Long> coins = new ArrayList<>();
        coins.add((long)2);
        coins.add((long)5);
        coins.add((long)3);
        coins.add((long)6);

        System.out.println("Mikey's approach: " + getWays(10, coins));
        System.out.println("Julian's approach: " + julianGetWays(10, coins));
    }

    /**
     * Given an amount and the denominations of coins available, determine how many ways change can be made for amount. There is a limitless supply of each coin type.

    Example


    There are  ways to make change for : , , and .

    Function Description

    Complete the getWays function in the editor below.

    getWays has the following parameter(s):

    int n: the amount to make change for
    int c[m]: the available coin denominations
    Returns

    int: the number of ways to make change
     * @param n
     * @param c
     * @return
     */
    public static long getWays(int n, List<Long> c) {
        // there is one way to match 0 cents - the empty set
        long[][] numWays = new long[n+1][c.size()];
        long[] coins = new long[c.size()];
        Arrays.sort(coins);
        int currentIdx = 0;
        for (long val : c){
            coins[currentIdx++] = val;
        }

        for (int i=0; i<coins.length; i++){
            numWays[0][i] = 1;
            // regardless of how many coins we are allowed, this is how many ways there are to match zero cents
        }

        // now for the bottom up dynamic programming
        for (int i=1; i<numWays.length; i++){
            for (int j=0; j<numWays[i].length; j++){
                int cents = i;
                long coinVal = coins[j];
                // we are only allowed to use coins from coins[0-j] (inclusive)
                if (coinVal > cents){
                    // we can't use this coin
                    if (j>0){
                        numWays[i][j] = numWays[i][j-1];
                    } else {
                        numWays[i][j] = 0;
                    }
                } else {
                    // we can match the coin - add however many ways there are with THOSE cents remaining
                    if (j>0){
                        numWays[i][j] = numWays[i][j-1] + numWays[i-(int)coinVal][j];
                        // the number of ways WITH using this coin PLUS those without
                    } else {
                        numWays[i][j] = numWays[i-(int)coinVal][j];
                        // we can ONLY consider the possibility of using this coin
                    }
                }
            }
        }

        return numWays[n][c.size()-1];
    }

    /*
     * A different attempt at figuring out the amount of ways to get change for a given 
     * amount with a limitless supply of coins of a specific denomination
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER amount
     *  2. LONG_INTEGER_ARRAY coins
     */

     public static long julianGetWays(int amount, List<Long> coins) {
        long[] combinations = new long[amount + 1];
        combinations[0] = 1;
        for (long coin : coins) {
            // starting at 1 because 0 is already defined
            // i represents the amount of change, and combinations[i] represents number of combinations for the amount of change
            for (long i = 1; i < combinations.length; i += 1) {
                // if the amount of change is more than the value of the coin that we have, then we have to refer back to figure out if there's another combination we can add
                if (i >= coin) {
                    combinations[(int) (i)] += combinations[(int) (i - coin)];
                }
            }
        }
        
        return combinations[amount];
    }
}