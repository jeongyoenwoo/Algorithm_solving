import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > 0)
                positiveQ.offer(temp);
            else
                negativeQ.offer(Math.abs(temp));
        }

        int maxV = 0;
        if (positiveQ.isEmpty()) {
            maxV = negativeQ.peek();
        } else if (negativeQ.isEmpty()) {
            maxV = positiveQ.peek();
        } else {
            maxV = Math.max(positiveQ.peek(), negativeQ.peek());
        }

        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();

            for (int i = 0; i < M - 1; i++) {
                positiveQ.poll();
            }

            ans += temp * 2;

        }

        while (!negativeQ.isEmpty()) {
            int temp = negativeQ.poll();

            for (int i = 0; i < M - 1; i++) {
                negativeQ.poll();
            }

            ans += temp * 2;

        }

        ans -= maxV;

        System.out.println(ans);
    }
}
