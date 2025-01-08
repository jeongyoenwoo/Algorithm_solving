import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[][] map;
    public static int[][] memo;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static int startX = 0, startY = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        memo = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 2) {
                    startX = i;
                    startY = j;
                }
                map[i][j] = num;
            }
        }

        memo[startX][startY] = 0;
        bfs(startX, startY);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (memo[i][j] == 0 && map[i][j] == 1) {
                    memo[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(memo[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

    public static void bfs(int startX, int startY) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cy < 0 || cx >= n || cy >= m)
                    continue;

                if (map[cx][cy] == 1 && memo[cx][cy] == 0) {
                    memo[cx][cy] = memo[x][y] + 1;
                    q.offer(new Node(cx, cy));
                }

            }
        }
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
