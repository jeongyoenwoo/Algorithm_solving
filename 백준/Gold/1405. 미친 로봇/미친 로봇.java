import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static double[] prob = new double[4];
    static double result = 0;
    static boolean[][] visited = new boolean[30][30];
    static int[] dx = { 0, 0, 1, -1 };
    static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            prob[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        dfs(15, 15, 0, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, int idx, double total) {
        if (idx == N) {
            result += total;
            return;
        }

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cy < 0 || cx >= 30 || cy >= 30)
                continue;

            if (!visited[cx][cy]) {
                visited[cx][cy] = true;
                dfs(cx, cy, idx + 1, total * prob[i]);
                visited[cx][cy] = false;
            }

        }
    }

}