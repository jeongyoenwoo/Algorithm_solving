import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static int[] num;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minQ = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (maxQ.size() == minQ.size()) {
                maxQ.add(num);

                if (!minQ.isEmpty() && maxQ.peek() > minQ.peek()) {
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }

            } else {
                minQ.add(num);

                if (maxQ.peek() > minQ.peek()) {
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }

            System.out.println(maxQ.peek());
        }

    }
}
