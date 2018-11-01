package impl;

/**
 * https://www.geeksforgeeks.org/maximum-subarray-sum-using-prefix-sum/
 * https://www.hackerrank.com/challenges/maximum-subarray-sum/problem
 * */
public class MaxSubArrayPrefixSum {


    private static long [] kadane(long [] values) {
        long rs [] = {0, 0, values[0]};
        long acc = 0;
        for (int i = 1; i < values.length; i++) {
            acc += values[i];
            if (acc < 0) {
                rs[0] = i + 1;
                rs[1] = i + 1;
                rs[2] = Math.max(acc, rs[2]);
                acc = 0;
            }
            else {
                if (acc > rs[2]) {
                    rs[1] = i;
                    rs[2] = acc;
                }
            }
        }
        if (rs[0] > rs[1])
            rs[0] = rs[1];
        return rs;
    }

    private static long prefix(long [] values) {
        long prefixSum [] = new long[values.length];
        prefixSum[0] = values[0];
        for (int i = 1; i < values.length ; i++) {
            prefixSum[i] = prefixSum[i-1] + values[i];
        }
        long minPrefixSum = 0, rs = Long.MIN_VALUE;
        for (long aPrefixSum : prefixSum) {
            long a = aPrefixSum - minPrefixSum;
            rs = Math.max(rs, a);
            minPrefixSum = Math.min(minPrefixSum, aPrefixSum);
        }
        return rs;
    }


    private static void print(long [] s) {
        System.out.printf("%d %d %d\n", s[0], s[1], s[2]);
    }



    public static void main(String[] args) {
        //System.out.println(prefix(kadane(new long[] {4, -8, 9, -4, 1, -8, -1, 6})));
        //System.out.println(prefix(kadane(new long[] {-2, -3, 4, -1, -2, 1, 5, -3})));
        print(kadane(new long[] {-4, -8, -9, -4, -1, -8, -1, -6}));
        print(kadane(new long[] {4, -8, 9, -4, 1, -8, -1, 6}));
        print(kadane(new long[] {-2, -3, 4, -1, -2, 1, 5, -3}));
        System.out.println(prefix(new long[] {-20, 30, -10}));
        System.out.println(prefix(new long[] {10, 20, 30}));
        System.out.println(prefix(new long[] {10, 20, -30}));
        System.out.println(prefix(new long[] {10, 20, 30, -40}));
        System.out.println(prefix(new long[] {4, -8, 9, -4, 1, -8, -1, 6}));
        System.out.println(prefix(new long[] {-2, -3, 4, -1, -2, 1, 5, -3}));


    }
}
