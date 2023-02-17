import java.io.*;
import java.util.*;

public class SubstringDiff {
    // Given two strings and an integer k, determine the length of the 
    // longest common substrings of the two strings that differ in no more than k positions.
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // 0011 & 0110 -> 0010
    static int LOWER_MASK = (1 << 16) - 1;
    static int UPPER_MASK = (LOWER_MASK << 16);

    public static int addEditDistance(int x, int addDist) {
        return x + (addDist << 16);
    }

    public static int addStringLength(int x, int stringLength) {
        return x + stringLength;
    }

    public static int getEditDistance(int x) {
        return (x & UPPER_MASK) >> 16;
    }

    public static int getStringLength(int x) {
        return x & LOWER_MASK;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(reader.readLine().trim());
        int[][] mat = new int[1501][1501];

        for (int te = 1; te <= t; te += 1) {
            String[] split = reader.readLine().trim().split(" ");
            int k = Integer.parseInt(split[0].trim());
            String s1 = split[1].trim(), s2 = split[2].trim();
        }
    }

}
