import java.io.*;
import java.util.*;

public class GhostLeg {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String [] args) throws IOException {
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        int numCols = nm[0];
        int numRungs = nm[1];

        int[] marbles = new int[numCols];
        int[] rungs = new int[numRungs];
        for (int i = 0; i < rungs.length; i += 1) {
            rungs[i] = Integer.parseInt(reader.readLine());
        }
        for (int col = 1; col <= numCols; col+=1) {
            int currentColumn = col;
            for (int i = 0; i < rungs.length; i += 1) {
                // establishing base cases
                if (currentColumn == 1 && rungs[i] == 1) {
                    currentColumn += 1;
                }
                else if (currentColumn == numCols && rungs[i] == numCols) {
                    currentColumn -= 1;
                } else {
                    if (rungs[i] == currentColumn - 1) {
                        currentColumn -= 1;
                    }
                    else if (rungs[i] == currentColumn) {
                        currentColumn += 1;
                    }
                }
            }
            marbles[currentColumn - 1] = col;
        }

        for (int column = 0; column < marbles.length; column += 1) {
            System.out.println(marbles[column]);
        }
    }
}
