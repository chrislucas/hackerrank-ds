package solution;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class DynArray {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), true);

    private static ArrayList<ArrayList<Integer>> seqList = new ArrayList<>();
    private static int lastAnswer = 0;


    private static void run() {
        try {
            StringTokenizer  tk = new StringTokenizer(reader.readLine(), " ");
            int n = Integer.parseInt(tk.nextToken());
            int q = Integer.parseInt(tk.nextToken());

            for (int i = 0; i < n ; i++) {
                seqList.add(new ArrayList<>());
            }

            for (int i = 0; i < q ; i++) {
                tk = new StringTokenizer(reader.readLine(), " ");
                int type = Integer.parseInt(tk.nextToken());
                int le = Integer.parseInt(tk.nextToken());
                int ri = Integer.parseInt(tk.nextToken());
                int seq =  (le ^ lastAnswer) % n;
                if (type == 1) {
                    seqList.get(seq).add(ri);
                }
                else {
                    int size = seqList.get(seq).size();
                    lastAnswer = seqList.get(seq).get(ri % size);
                    writer.printf("%d\n", lastAnswer);
                }
            }

        } catch (IOException e) {}
    }

    public static void main(String[] args) throws IOException {
        run();
    }
}
