import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, L, K;
    public static List<Node> list = new ArrayList<>();
    public static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y));
        }

        for (Node a : list) {
            for (Node b : list) {
                int x = a.x;
                int y = b.y;
                int sum = 0;

                // 기준점을 왼쪽 위 꼭짓점에
                int cx = x + L;
                int cy = y + L;

                for (Node cn : list) {
                    if (cn.x >= x && cn.x <= cx && cn.y >= y && cn.y <= cy)
                        sum++;
                }
                max = Math.max(max, sum);
            }

        }

        System.out.println(K - max);
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
