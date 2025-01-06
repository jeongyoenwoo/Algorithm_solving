import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int start = Integer.MAX_VALUE;
    public static int end = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            nodes[i] = new Node(L, H);
        }

        Arrays.sort(nodes);

        int answer = 0;
        int pivot = 0;

        for (int i = 0; i < N; i++) {
            if (nodes[i].height > nodes[pivot].height)
                pivot = i;
        }

        answer += nodes[pivot].height;

        int start = 0;

        for (int i = 0; i <= pivot; i++) {
            int height = nodes[i].height;
            int location = nodes[i].location;

            if (nodes[start].height <= height) {
                answer += (nodes[start].height * (location - nodes[start].location));
                start = i;
            }
        }

        start = N - 1;

        for (int i = N - 1; i >= pivot; i--) {
            int height = nodes[i].height;
            int location = nodes[i].location;

            if (nodes[start].height <= height) {
                answer += (nodes[start].height * (nodes[start].location - location));
                start = i;
            }
        }

        System.out.println(answer);

    }

    public static class Node implements Comparable<Node> {
        int location;
        int height;

        public Node(int location, int height) {
            this.location = location;
            this.height = height;
        }

        @Override
        public int compareTo(Node n) {
            return this.location - n.location;
        }
    }

}
