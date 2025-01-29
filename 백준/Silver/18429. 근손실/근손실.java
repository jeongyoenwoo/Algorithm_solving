import java.io.*;
import java.util.*;

public class Main {

    public static int N, K;
    public static int[] arr;
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(500, 0);

        System.out.println(answer);
    }

    public static void dfs(int sum, int idx) {
        if (idx == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i] && (sum + arr[i] - K) >= 500) {
                visited[i] = true;
                dfs(sum + arr[i] - K, idx + 1);
                visited[i] = false;
            }
        }
    }
}
