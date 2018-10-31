package solution;

import java.util.Arrays;

public class Solution {


    static int [] prefixSum(int [] a) {
        for (int i = 1; i < a.length ; i++) {
            a[i] += a[i-1];
        }
        return a;
    }

    /**
     * O array resultante eh 1 unidade menor do que o array processado
     * */
    static int [] diffArray(int [] a, int p) {
        int data [] = new int[a.length-1];

        for (int i = 0; i <a.length-1; i++) {
            data[i] = a[i+1] - a[i];
        }

        return data;
    }

    /**
     * Array resultante e 1 unidade maior que o array processado
     * */
    static int [] prefixSum(int [] a, int p) {
        int [] data = new int[a.length+1];
        data[0] = p;
        for (int i = 0; i < a.length ; i++) {
            data[i+1] = data[i] + a[i];
        }
        return data;
    }

    static long arrayManipulation(int n, int[][] queries) {
        int [] values = new int[n+1];
        Arrays.fill(values, 0);
        for (int query[] : queries) {
            int i = query[0], j = query[1], k = query[2];
            // o i-esimo elemento e acrescido de k
            // os valores armazenados em values[i+1 ... j] (j inclusive) nao tem diferenca de de values[i]
            values[i] += k;
            // os valores apos j (caso j nao seja o ultimo indice do vetor) tem armazenado um valor Q - k
            if ((j+1) <= n)
                values[j+1] -= k;
        }
        long acc = 0, max = 0;
        for (int i = 1; i <=n; i++) {
            acc += values[i];
            if (max < acc)
                max = acc;
        }
        return max;
    }

    public static void main(String[] args) {
        int [][][] queries = {
            {{1,5,3}, {4,8,7}, {6,9,1}}
            ,{{1,2,100}, {2,5,100}, {3,4,100}}
            ,{{1,2,3}}
            ,{{1,2,3},{2,3,4}}
        };
        //System.out.println(arrayManipulation(10, queries[0]));
        //System.out.println(arrayManipulation(5, queries[1]));
        //System.out.println(arrayManipulation(5, queries[2]));
        System.out.println(arrayManipulation(5, queries[3]));
    }
}
