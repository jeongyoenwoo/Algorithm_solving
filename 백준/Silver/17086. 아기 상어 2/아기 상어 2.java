import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
    public static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };
    public static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        int num = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 1) {
                    num = bfs(i, j);
                    answer = Math.max(answer, num);
                }
            }
        }

        System.out.println(answer);

    }

    public static int bfs(int x, int y) {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        visited = new boolean[N][M];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();

            for (int i = 0; i < 8; i++) {
                int cx = n.x + dx[i];
                int cy = n.y + dy[i];
                int count = n.count + 1;

                if (cx < 0 || cy < 0 || cx >= N || cy >= M)
                    continue;

                if (visited[cx][cy])
                    continue;

                if (map[cx][cy] == 1) {
                    return count;
                }

                q.add(new Node(cx, cy, count));
                visited[cx][cy] = true;

            }
        }

        return 0;
    }

    public static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
