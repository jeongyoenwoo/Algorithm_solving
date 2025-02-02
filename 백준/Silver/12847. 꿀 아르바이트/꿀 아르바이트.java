import java.io.*;
import java.util.*;

public class Main {

    public static int n, m;
    public static int[] money;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        money = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        for (int i = 0; i < m; i++) {
            sum += money[i];
        }

        long max = sum;
        for (int i = m; i < n; i++) {
            sum -= money[i - m];
            sum += money[i];

            max = Math.max(max, sum);
        }

        System.out.println(max);

    }

}
