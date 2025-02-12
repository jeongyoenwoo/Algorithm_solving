import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, K;
    public static boolean[][][] visited;
    public static int[][] map;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
        } else {
            System.out.print(min);
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            if (n.x == (N - 1) && n.y == (M - 1)) {
                min = Math.min(min, n.move);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int cx = n.x + dx[i];
                int cy = n.y + dy[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M)
                    continue;

                if (!visited[cx][cy][n.b] && map[cx][cy] == 0) {

                    visited[cx][cy][n.b] = true;
                    q.offer(new Node(cx, cy, n.b, n.move + 1));
                } else if (n.b < K && !visited[cx][cy][n.b + 1] && map[cx][cy] == 1) {
                    visited[cx][cy][n.b + 1] = true;
                    q.offer(new Node(cx, cy, n.b + 1, n.move + 1));
                }
            }
        }

    }

    public static class Node {
        int x;
        int y;
        int b;
        int move;

        public Node(int x, int y, int b, int move) {
            this.x = x;
            this.y = y;
            this.b = b;
            this.move = move;
        }
    }

}
