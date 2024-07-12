import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            pq.add(n);
        }

        long ans = 0;

        while (pq.size() != 1) {
            int a = pq.poll();
            int b = pq.poll();

            int sum = a + b;
            ans += sum;
            pq.add(sum);
        }

        System.out.println(ans);
    }
}
