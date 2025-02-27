import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int open1, open2;
    public static int[] arr;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        open1 = Integer.parseInt(st.nextToken());
        open2 = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        bfs(0, 0, open1, open2);

        System.out.print(min);
    }

    public static void bfs(int cur, int num, int o1, int o2) {
        if (num > min) {
            return;
        }

        if (cur == M) {
            min = Math.min(min, num);
            return;
        }

        bfs(cur + 1, num + Math.abs(o1 - arr[cur]), arr[cur], o2);
        bfs(cur + 1, num + Math.abs(o2 - arr[cur]), o1, arr[cur]);
    }
}
