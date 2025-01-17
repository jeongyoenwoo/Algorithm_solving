import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int min = Integer.MAX_VALUE;
    public static int[][] map;
    public static boolean[][][] visited;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[2][N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(-1);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, 0));

        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y = n.y;
            int len = n.len;
            int num = n.num;

            if (x == N - 1 && y == M - 1) {
                System.out.println(len);
                System.exit(0);
            }

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= M)
                    continue;

                if (num == 0) {
                    if (!visited[0][cx][cy]) {
                        if (map[cx][cy] == 1) {
                            visited[1][cx][cy] = true;
                            q.offer(new Node(cx, cy, len + 1, num + 1));
                        } else {
                            visited[0][cx][cy] = true;
                            q.offer(new Node(cx, cy, len + 1, num));
                        }
                    }
                }

                if (num == 1) {
                    if (!visited[1][cx][cy] && map[cx][cy] == 0) {
                        visited[1][cx][cy] = true;
                        q.offer(new Node(cx, cy, len + 1, num));
                    }
                }
            }
        }
    }

    public static class Node {
        int x;
        int y;
        int len;
        int num;

        public Node(int x, int y, int len, int num) {
            this.x = x;
            this.y = y;
            this.len = len;
            this.num = num;
        }
    }

}
