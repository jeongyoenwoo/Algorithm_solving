import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static char[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j))
                    result++;
            }
        }

        System.out.print(result);

    }

    public static boolean dfs(int x, int y) {
        boolean result = false;

        if (x < 0 || y < 0 || x >= N || y >= M) {
            return true;
        }

        if (map[x][y] == 'T')
            return true;
        if (map[x][y] == 'F')
            return false;

        if (visited[x][y])
            return false;

        visited[x][y] = true;

        if (map[x][y] == 'U') {
            result = dfs(x - 1, y);
        } else if (map[x][y] == 'R') {
            result = dfs(x, y + 1);
        } else if (map[x][y] == 'D') {
            result = dfs(x + 1, y);
        } else if (map[x][y] == 'L') {
            result = dfs(x, y - 1);
        }

        if (result) {
            map[x][y] = 'T';
        } else {
            map[x][y] = 'F';
        }

        return result;
    }

}
