import java.io.*;
import java.util.*;

public class Main {

    public static Node home;
    public static List<Node> storeList;
    public static Node end;
    public static boolean[] visited;
    public static boolean check = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int test_case = Integer.parseInt(st.nextToken());

        for (int t = 0; t < test_case; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N != 0)
                visited = new boolean[N];
            storeList = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            home = new Node(x, y);

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                storeList.add(new Node(x, y));
            }

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            end = new Node(x, y);

            if (getDistance(home.x, home.y, end.x, end.y) <= 1000) {
                check = true;
            } else {
                dfs(home.x, home.y);
            }

            if (check)
                sb.append("happy");
            else
                sb.append("sad");

            sb.append("\n");

            storeList.clear();
            check = false;
        }

        System.out.println(sb);
    }

    public static void dfs(int cx, int cy) {
        if (getDistance(cx, cy, end.x, end.y) <= 1000) {
            check = true;
            return;
        }

        if (check) {
            return;
        }

        for (int i = 0; i < storeList.size(); i++) {
            if (visited[i])
                continue;

            Node store = storeList.get(i);

            if (getDistance(cx, cy, store.x, store.y) <= 1000) {
                visited[i] = true;
                dfs(store.x, store.y);
            }

        }
    }

    public static int getDistance(int cx, int cy, int targetX, int targetY) {
        int dist = Math.abs(targetX - cx) + Math.abs(targetY - cy);

        return dist;
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
