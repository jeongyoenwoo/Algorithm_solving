import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;
    public static int min = Integer.MAX_VALUE;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);
    }

    public static void dfs(int count, int sum) {

        if (count == 3) {
            min = Math.min(min, sum);
            return;
        }

        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (!visited[i][j] && check(i, j)) {
                    visited[i][j] = true;
                    dfs(count + 1, sum + getSum(i, j));
                    visitClear(i, j);
                }
            }
        }
    }

    public static boolean check(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (visited[cx][cy])
                return false;
        }

        return true;
    }

    public static int getSum(int x, int y) {
        int sum = map[x][y];

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            visited[cx][cy] = true;
            sum += map[cx][cy];
        }

        return sum;
    }

    public static void visitClear(int x, int y) {

        visited[x][y] = false;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            visited[cx][cy] = false;
        }
    }
}
