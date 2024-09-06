import java.io.*;
import java.util.*;

public class Main {

    static int N, Q;
    static List<List<Node>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int usado = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            q.add(new Node(start, 0));
            boolean[] visited = new boolean[N + 1];
            visited[start] = true;
            int total = 0;

            while (!q.isEmpty()) {
                Node node = q.poll();

                for (Node n : list.get(node.end)) {
                    if (!visited[n.end] && n.weight >= usado) {
                        visited[n.end] = true;
                        total++;
                        q.add(new Node(n.end, Math.min(node.weight, n.weight)));
                    }
                }
            }

            System.out.println(total);
        }
    }

    public static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }

}