package problems.codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * http://codeforces.com/problemset/problem/433/B
 * */

public class B433 {

    private static int[] prepare(int [] array) {
        int sorted [] = new int[array.length];
        System.arraycopy(array, 0, sorted, 0, sorted.length);
        Arrays.sort(sorted);
        return sorted;
    }


    private static int [] segmentTree(int [] array) {
        int segment [] = new int[array.length];

        return segment;
    }


    private static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer tk = new StringTokenizer(reader.readLine(), " ");
            int [] array = new int[n];
            for (int i = 0; tk.hasMoreTokens() ; i++)
                array[i] = Integer.parseInt(tk.nextToken());
            int sorted [] = prepare(array);

            tk = new StringTokenizer(reader.readLine(), " ");
            int t = Integer.parseInt(tk.nextToken());
            int l = Integer.parseInt(tk.nextToken());
            int r = Integer.parseInt(tk.nextToken());

        } catch (IOException ignore) {}
    }

    public static void main(String[] args) {
        run();
    }
}
