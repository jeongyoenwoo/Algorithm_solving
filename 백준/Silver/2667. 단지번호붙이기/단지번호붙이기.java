import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int cnt = 1;
    public static List<Integer> list = new ArrayList<>();
    public static int[][] map;
    public static boolean[][] visited;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                    list.add(cnt);
                    cnt = 1;
                }
            }
        }
        Collections.sort(list);

        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 0 || cy < 0 || cx >= N || cy >= N)
                continue;

            if (map[cx][cy] == 1 && !visited[cx][cy]) {
                cnt++;
                dfs(cx, cy);
            }
        }

    }

}