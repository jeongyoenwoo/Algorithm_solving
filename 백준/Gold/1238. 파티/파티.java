import java.util.*;
import java.io.*;

public class Main {

    public static int N, M, X;
    public static ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public static int dist[];
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<Node>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (i != X) {
                max = Math.max(max, dijkstra(i, X) + dijkstra(X, i));
            }
        }

        System.out.println(max);

    }

    public static int dijkstra(int start, int end) {

        dist = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int cur = node.end;

            if (!visited[cur]) {

                visited[cur] = true;

                for (Node n : list.get(cur)) {
                    if (!visited[n.end] && dist[n.end] > dist[cur] + n.weight) {
                        dist[n.end] = dist[cur] + n.weight;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }

        return dist[end];
    }

    public static class Node implements Comparable<Node> {

        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }

}
