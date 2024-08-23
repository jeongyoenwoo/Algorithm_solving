import java.util.*;
import java.io.*;

public class Main {

    public static int N, K, D;
    public static int[] acorn;
    public static List<Node> list = new ArrayList<>();
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int diff = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, diff));
            min = Math.min(min, start);
        }

        int start = 1;
        int end = N;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (getCount(mid) < D) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start);

    }

    public static long getCount(int mid) {
        long count = 0;

        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);

            if (node.start > mid)
                continue;

            if (node.end <= mid) {
                count += (node.end - node.start) / node.diff + 1;
                continue;
            }

            count += (mid - node.start) == 0 ? 1 : (mid - node.start) / node.diff + 1;
        }

        return count;
    }

    public static class Node {
        int start;
        int end;
        int diff;

        public Node(int start, int end, int diff) {
            this.start = start;
            this.end = end;
            this.diff = diff;
        }
    }

}
