import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static List<List<Node>> list = new ArrayList<>();
    public static long[] dist;
    public static int[] visible;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }
        dist = new long[N];
        Arrays.fill(dist, Long.MAX_VALUE);
        visible = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visible[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        dijkstra(0);

        if (dist[N - 1] == Long.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(dist[N - 1]);
    }

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        boolean[] visited = new boolean[N];
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur = node.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node n : list.get(cur)) {
                    if (n.end != N - 1 && visible[n.end] == 1)
                        continue;

                    if (dist[n.end] > dist[cur] + n.weight) {
                        dist[n.end] = dist[cur] + n.weight;
                        pq.offer(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }

    }

    public static class Node implements Comparable<Node> {
        int end;
        long weight;

        public Node(int end, long weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            if (weight - o.weight > 0)
                return 1;
            else
                return -1;
        }

    }

}
