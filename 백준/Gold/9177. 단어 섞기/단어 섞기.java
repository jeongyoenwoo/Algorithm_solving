import java.io.*;
import java.util.*;

public class Main {

    public static int T;
    public static char[] c1, c2, out;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            String[] str = br.readLine().split(" ");
            c1 = str[0].toCharArray();
            c2 = str[1].toCharArray();
            out = str[2].toCharArray();

            if (bfs()) {
                sb.append("Data set ");
                sb.append(t);
                sb.append(": yes\n");
            } else {
                sb.append("Data set ");
                sb.append(t);
                sb.append(": no\n");
            }

        }

        System.out.print(sb.toString());
    }

    public static boolean bfs() {
        Queue<Node> q = new LinkedList<>();
        visited = new boolean[201][201];

        q.offer(new Node(0, 0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            int idx1 = n.idx1;
            int idx2 = n.idx2;
            int outIdx = n.outIdx;

            if (outIdx == out.length) {
                return true;
            }

            if (idx1 < c1.length && !visited[idx1 + 1][idx2] && c1[idx1] == out[outIdx]) {
                visited[idx1 + 1][idx2] = true;
                q.offer(new Node(idx1 + 1, idx2, outIdx + 1));
            }

            if (idx2 < c2.length && !visited[idx1][idx2 + 1] && c2[idx2] == out[outIdx]) {
                visited[idx1][idx2 + 1] = true;
                q.offer(new Node(idx1, idx2 + 1, outIdx + 1));
            }

        }

        return false;
    }

    public static class Node {
        int idx1;
        int idx2;
        int outIdx;

        public Node(int idx1, int idx2, int outIdx) {
            this.idx1 = idx1;
            this.idx2 = idx2;
            this.outIdx = outIdx;
        }
    }

}
