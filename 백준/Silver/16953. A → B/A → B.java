import java.util.*;
import java.io.*;

public class Main {

    public static long A, B;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(A, 1);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    public static void dfs(long num, int count) {

        if (num == B) {
            min = Math.min(min, count);
            return;
        }

        if (num > B)
            return;

        dfs(num * 2, count + 1);
        dfs(num * 10 + 1, count + 1);

    }
}
