package impl;



import static java.lang.Math.*;

/**
 * https://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/
 * */
public class SegmentTree {

    private int [] segment, data;
    private int n;

    SegmentTree(int [] data) {
        this.data = data;
        this.n = data.length;
        int h = (int) (ceil(log(n)/log(2)));
        int m = 2 * (int) pow(2, h) - 1;
        this.segment = new int[m];
        build(this.data, 0, this.n-1, 0);
    }

    private int build(int [] data, int s, int e, int i) {
        if (s == e) {
            segment[i] = data[s];
            return data[s];
        }
        int m = (e-s)/2+s;
        int l = build(data, s, m, 2*i+1);
        int r = build(data, m+1, e, 2*i+2);
        segment[i] = l + r;
        return segment[i];
    }

    public int getRangeSum(int qs, int qe) throws Exception {
        if (qs < 0 || qe > n-1 || qs > qe)
            throw new Exception("Fora do range");
        return getRangeSum(0, n-1, qs, qe, 0);
    }

    private int getRangeSum(int ss, int es, int qs, int qe, int i) {
        // se o intervalo de busca estiver entre o intervalo do segmento
        if (qs <= ss && qe >= es)
            return segment[i];
        else if (qs > es || qe < ss)
            return 0;
        int m = (es-ss)/2+ss;
        int l = getRangeSum(ss, m, qs, qe, 2*i+1);
        int r = getRangeSum(m+1, es, qs, qe, 2*i+2);
        return l + r;
    }


    private void update(int i, int newVal) throws Exception {
        if ( i < 0 || i > n-1)
            throw new Exception("");
        // diferenca para atualizar a segment tree
        int diff = newVal - data[i];
        data[i] = newVal;
        update(0, n-1, i, diff, 0);
    }

    /**
     * ss = start segment, es = end segment, iu = index update
     * , value = valor para atualizar, i = indice
     *
     */
    private void update(int ss, int es, int iu, int value, int i) {
        if (iu < ss || iu > es)
            return;
        segment[i] += value;
        if (ss != es) {
            int m = (es-ss)/2+ss;
            update(ss, m, iu, value, 2*i+1);
            update(m+1, es, iu, value, 2*i+2);
        }
    }

    public static void main(String[] args) throws Exception {
        int [] arr = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);
        System.out.println(st.getRangeSum(0, 3));
        st.update(0, 10);
        System.out.println(st.getRangeSum(0, 1));
        st.update(5, -10);
        System.out.println(st.getRangeSum(0, 2));
        System.out.println(st.getRangeSum(1, 2));
        System.out.println(st.getRangeSum(4, 5));
        System.out.println(st.getRangeSum(0, 5));
    }
}
