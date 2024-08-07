import java.util.*;
import java.io.*;

public class Main {

    public static int N, D;
    public static List<Node> list = new ArrayList<>();
    public static int[] dist; // 지름길 길이 저장
    public static int[] dp = new int[10001]; // 최단거리 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[D + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (D < end)
                continue;
            if (end - start <= weight)
                continue;

            list.add(new Node(start, end, weight));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        dijkstra();
        System.out.println(dp[D]);
    }

    public static void dijkstra() {
        int move = 0;
        int index = 0;

        while (move < D) {
            if (index < list.size()) {
                Node road = list.get(index);

                if (move == road.start) {
                    dp[road.end] = Math.min(dp[road.start] + road.weight, dp[road.end]);
                    index++;
                } else {
                    dp[move + 1] = Math.min(dp[move] + 1, dp[move + 1]);
                    move++;

                }
            } else {
                dp[move + 1] = Math.min(dp[move] + 1, dp[move + 1]);
                move++;
            }
        }
    }

    public static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }

}
