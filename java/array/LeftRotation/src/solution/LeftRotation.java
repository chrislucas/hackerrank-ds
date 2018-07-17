package solution;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.hackerrank.com/challenges/array-left-rotation/problem
 * DONE
 * */

public class LeftRotation {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out)
            , true);


    private static int [] getIndexes(int n, int shiftLeft) {
        int [] indexes = new int [n];
        shiftLeft %= n;
        for (int i = 0; i < n ; i++) {
            int idx = i - shiftLeft < 0 ? n - (shiftLeft - i) : i - shiftLeft;
            indexes[idx] = i;
        }
        return indexes;
    }

    public static void main(String[] args) {

        //getIndexes(10, 5);

        try {
            StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tk.nextToken());
            int d = Integer.parseInt(tk.nextToken());
            tk = new StringTokenizer(reader.readLine(), " ");
            int [] numbers = new int[n];
            for (int i = 0; tk.hasMoreTokens() ; i++) {
                numbers[i] = Integer.parseInt(tk.nextToken());
            }
            int [] indexes = getIndexes(n, d);
            for (int i = 0; i < n ; i++) {
                writer.printf(i == 0 ? "%d" : " %d", numbers[indexes[i]]);
            }
            
        } catch (IOException e) {}
    }
}
