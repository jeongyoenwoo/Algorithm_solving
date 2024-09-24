import java.io.*;
import java.util.*;

public class Main {

    static int N, d, k, c;
    static int[] list;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        check();

        System.out.println(max);
    }

    public static void check() {
        boolean[] visited;
        for (int i = 0; i < N; i++) {
            visited = new boolean[d + 1];

            int idx = i;
            for (int j = 0; j < k; j++) {
                if (idx + j >= N) {
                    visited[list[idx + j - N]] = true;
                } else {
                    visited[list[idx + j]] = true;
                }
            }

            visited[c] = true;

            max = Math.max(max, checkNum(visited));
        }
    }

    public static int checkNum(boolean[] visited) {

        int num = 0;

        for (int i = 0; i <= d; i++) {
            if (visited[i])
                num++;
        }

        return num;
    }

}
