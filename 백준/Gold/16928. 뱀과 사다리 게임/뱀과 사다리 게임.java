import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int answer = 0;
    public static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map.put(start, end);
        }

        bfs();

        System.out.println(answer);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            int cur = n.num;
            int count = n.count;

            if (cur == 100) {
                answer = count;
                break;
            }

            if (map.containsKey(cur)) {
                cur = map.get(cur);
            }

            for (int i = 1; i <= 6; i++) {
                if (cur + i > 100 || visited[cur + i])
                    continue;

                visited[cur + i] = true;
                q.offer(new Node(cur + i, count + 1));
            }
        }
    }

    public static class Node {
        int num;
        int count;

        public Node(int num, int count) {
            this.num = num;
            this.count = count;
        }

    }

}
