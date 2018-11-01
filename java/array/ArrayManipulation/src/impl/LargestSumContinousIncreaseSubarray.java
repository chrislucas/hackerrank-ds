package impl;


/**
 * https://www.geeksforgeeks.org/largest-sum-contiguous-increasing-subarray/
 * */
public class LargestSumContinousIncreaseSubarray {

    private static long[] run(long[] array) {
        long [] interval = {0, 0, 0};
        for (int i = 0; i < array.length; i++) {
            int ti = i, tj = i;
            long acc = array[i];
            for (; i+1 < array.length && array[i] < array[i+1] ; ) {
                tj = i+1;
                acc += array[i+1];
                i++;
            }
            if (acc > interval[2]) {
                interval[0] = ti;
                interval[1] = tj;
                interval[2] = acc;
            }
        }
        return interval;
    }

    private static void print(long [] s) {
        System.out.printf("%d %d %d\n", s[0], s[1], s[2]);
    }

    public static void main(String[] args) {
        print(run(new long[] {2, 1, 4, 7, 3, 6}));
        print(run(new long[] {38, 7, 8, 10, 12}));
        print(run(new long[] {38, 7, 8, 10, 14}));
        print(run(new long[] {100, 7, 8, 10, 13}));
    }
}
