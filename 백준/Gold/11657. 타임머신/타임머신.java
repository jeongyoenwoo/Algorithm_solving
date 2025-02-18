import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.add(new Node(start, end, cost));
        }

        long[] dist = new long[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        for (int i = 0; i < N; i++) {
            for (Node n : list) {
                int start = n.start;
                int end = n.end;
                int cost = n.cost;

                if (dist[start] == Integer.MAX_VALUE)
                    continue;

                if (dist[end] > dist[start] + cost) {
                    dist[end] = dist[start] + cost;

                    if (i == N - 1) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                }

            }
        }

        for (int i = 2; i <= N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else
                System.out.println(dist[i]);
        }

    }

    public static class Node {
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

}
