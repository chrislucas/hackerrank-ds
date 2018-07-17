import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem?h_r=next-challenge&h_v=zen
 * DONE
 * */
public class SparseArray {


    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
        int rs [] = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j <strings.length ; j++) {
                if (queries[i].equals(strings[j]))
                    rs[i] += 1;
            }
        }
        return rs;
    }

    public static void main(String[] args) {

    }
}
