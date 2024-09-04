import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int[][] map;
    static boolean[][] slice;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        slice = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        dfs(0, 0);

        System.out.println(max);

    }

    public static void dfs(int x, int y) {

        if (x == N) {
            sum();
            return;
        }
        if (y == M) {
            dfs(x + 1, 0);
            return;
        }

        slice[x][y] = true; // 가로로 자르는 것을 선택(true)
        dfs(x, y + 1);
        slice[x][y] = false; // 세로로 자르는 것을 선택(false)
        dfs(x, y + 1);
    }

    public static void sum() {
        int result = 0;

        int sum;

        // 가로로 자른 종이들 합 구하기
        for (int i = 0; i < N; i++) {
            sum = 0;
            for (int j = 0; j < M; j++) {
                if (slice[i][j]) {
                    sum *= 10;
                    sum += map[i][j];
                } else {
                    result += sum;
                    sum = 0;
                }
            }
            result += sum;
        }

        // 세로로 자른 종이들 합 구하기
        for (int i = 0; i < M; i++) {
            sum = 0;
            for (int j = 0; j < N; j++) {
                if (!slice[j][i]) {
                    sum *= 10;
                    sum += map[j][i];
                } else {
                    result += sum;
                    sum = 0;
                }
            }
            result += sum;
        }

        max = Math.max(max, result);
    }
}