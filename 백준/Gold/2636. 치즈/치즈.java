import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static List<Node> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int cur = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cur++;
            }
        }

        int time = 1;
        int before = 0;

        while (true) {
            before = cur;
            bfs();

            cur = melting();

            if (cur == 0)
                break;

            time++;
        }

        System.out.println(time);
        System.out.println(before);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        list = new ArrayList<>();

        q.offer(new Node(0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = n.x + dx[i];
                int cy = n.y + dy[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M)
                    continue;

                if (!visited[cx][cy]) {
                    visited[cx][cy] = true;

                    if (map[cx][cy] == 0) {
                        q.offer(new Node(cx, cy));
                    } else {
                        list.add(new Node(cx, cy));
                    }
                }
            }
        }
    }

    public static int melting() {
        for (Node n : list) {
            map[n.x][n.y] = 0;
        }

        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1)
                    num++;
            }
        }

        return num;
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
