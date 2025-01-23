import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = { 1, 1, 1 };
    public static int[] dy = { -1, 0, 1 };
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            dfs(0, i, map[0][i], -1);
        }

        System.out.println(min);

    }

    public static void dfs(int x, int y, int sum, int direction) {
        if (x == N - 1) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {

            if (i == direction)
                continue;

            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cy < 0 || cy >= M)
                continue;

            if (!visited[cx][cy]) {
                visited[cx][cy] = true;
                dfs(cx, cy, sum + map[cx][cy], i);
                visited[cx][cy] = false;
            }

        }
    }
}
