import java.io.*;
import java.util.*;

public class Main {

    static int N, L, R, X;
    static int[] level;
    static int ans = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        level = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[N];
        dfs(0, -1, visited);

        System.out.println(ans);

    }

    public static void dfs(int cur, int index, boolean[] visited) {
        if (cur > R)
            return;

        if (check(visited)) {
            ans++;
        }

        for (int i = index + 1; i < N; i++) {
            visited[i] = true;
            dfs(cur + level[i], i, visited);
            visited[i] = false;
        }
    }

    public static boolean check(boolean[] visited) {

        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) {
                sum += level[i];
                max = Math.max(max, level[i]);
                min = Math.min(min, level[i]);
            }
        }

        if (sum >= L && sum <= R) {
            if ((max - min) >= X) {
                return true;
            }
        }

        return false;
    }

}
