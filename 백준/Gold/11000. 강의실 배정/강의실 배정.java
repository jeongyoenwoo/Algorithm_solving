import java.util.*;
import java.io.*;

public class Main {

    public static int N;

    public static List<Node> lesson = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            lesson.add(new Node(start, end));
        }

        Collections.sort(lesson);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);

        for (Node node : lesson) {
            if (pq.peek() <= node.start) {
                pq.poll();
            }
            pq.add(node.end);
        }

        System.out.println(pq.size());
    }

    public static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.start - o.start;
        }

    }

}
