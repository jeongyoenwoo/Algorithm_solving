import java.io.*;
import java.util.*;

public class Main {

    public static int N, L;
    public static int[][] map;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 가로 길
        for (int i = 0; i < N; i++) {
            if (rowCheck(i))
                answer++;
            if (colCheck(i))
                answer++;
        }

        System.out.println(answer);

    }

    public static boolean rowCheck(int r) {
        int c = 0;
        boolean[] visited = new boolean[N];

        while (c < N - 1) {
            if (Math.abs(map[r][c] - map[r][c + 1]) > 1) {
                return false;
            }

            if (map[r][c] + 1 == map[r][c + 1]) {
                if (visited[c])
                    return false;

                for (int i = 1; i < L; i++) {
                    if (c - i < 0 || map[r][c - i] != map[r][c] || visited[c - i]) {
                        return false;
                    }

                    visited[c - i] = true;
                }

                visited[c] = true;
            }

            if (map[r][c] - 1 == map[r][c + 1]) {
                if (visited[c + 1])
                    return false;

                for (int i = 2; i <= L; i++) {
                    if (c + i >= N || map[r][c + i] != map[r][c + 1] || visited[c + i]) {
                        return false;
                    }

                    visited[c + i] = true;
                }

                visited[c + 1] = true;
                c = c + L - 1;
            }

            c++;
        }

        return true;
    }

    public static boolean colCheck(int c) {
        int r = 0;
        boolean[] visited = new boolean[N];

        while (r < N - 1) {
            if (Math.abs(map[r][c] - map[r + 1][c]) > 1) {
                return false;
            }

            if (map[r][c] + 1 == map[r + 1][c]) {
                if (visited[r])
                    return false;

                for (int i = 1; i < L; i++) {
                    if (r - i < 0 || map[r - i][c] != map[r][c] || visited[r - i]) {
                        return false;
                    }

                    visited[r - i] = true;
                }

                visited[r] = true;
            }

            if (map[r][c] - 1 == map[r + 1][c]) {
                if (visited[r + 1])
                    return false;

                for (int i = 2; i <= L; i++) {
                    if (r + i >= N || map[r + i][c] != map[r + 1][c] || visited[r + i]) {
                        return false;
                    }

                    visited[r + i] = true;
                }

                visited[r + 1] = true;
                r = r + L - 1;
            }

            r++;
        }

        return true;
    }
}
