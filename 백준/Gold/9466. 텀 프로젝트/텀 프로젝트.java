import java.io.*;
import java.util.*;

public class Main {

    public static int T, N;
    public static int[] arr;
    public static boolean[] visited;
    public static boolean[] done;
    public static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            arr = new int[N + 1];
            visited = new boolean[N + 1];
            done = new boolean[N + 1];
            result = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (i == arr[i]) {
                    done[i] = true;
                    result++;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (!done[i]) {
                    dfs(i);
                }
            }

            System.out.println(N - result);
        }

    }

    public static void dfs(int num) {
        if (visited[num]) {
            result++;
            done[num] = true;
        } else {
            visited[num] = true;
        }

        if (!done[arr[num]]) {
            dfs(arr[num]);
        }

        visited[num] = false;
        done[num] = true;
    }

}
