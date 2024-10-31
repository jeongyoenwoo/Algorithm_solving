import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] psum = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                psum[i][j] = map[i][j] + psum[i][j - 1] + psum[i - 1][j] - psum[i - 1][j - 1];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = i; k <= N; k++) {
                    for (int l = j; l <= M; l++) {
                        int sum = psum[k][l] - psum[i - 1][l] - psum[k][j - 1] + psum[i - 1][j - 1];
                        max = Math.max(max, sum);
                    }
                }
            }
        }

        System.out.println(max);

    }
}
