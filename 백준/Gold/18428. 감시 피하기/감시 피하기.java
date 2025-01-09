import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static char[][] map;
    public static boolean[][] object;
    public static boolean answer = false;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        object = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);

        System.out.println("NO");

    }

    public static void dfs(int num) {
        if (num == 3) {
            if (bfs()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 'X') {
                    map[i][j] = 'O';
                    dfs(num + 1);
                    map[i][j] = 'X';
                }
            }
        }
    }

    public static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        char[][] copyMap = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];

                if (copyMap[i][j] == 'T') {
                    q.offer(new Node(i, j));
                }
            }
        }

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (int i = 0; i < 4; i++) {
                int cx = node.x;
                int cy = node.y;

                while (true) {
                    cx += dx[i];
                    cy += dy[i];

                    if (cx < 0 || cy < 0 || cx >= N || cy >= N)
                        break;

                    if (copyMap[cx][cy] == 'O')
                        break;

                    if (copyMap[cx][cy] == 'S')
                        return false;
                }
            }
        }

        return true;
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
