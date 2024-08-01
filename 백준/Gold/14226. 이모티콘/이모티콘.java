import java.util.*;
import java.io.*;

public class Main {

    public static int S;
    public static int min = Integer.MAX_VALUE;
    public static boolean[][] visited = new boolean[2001][2001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(min);

    }

    public static void bfs() {

        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 0, 0));

        while (!q.isEmpty()) {

            Node node = q.poll();
            int num = node.num;
            int cb = node.cb;
            int count = node.count;

            if (num == S) {
                min = count;
                break;
            }

            if (!visited[num][num]) {
                visited[num][num] = true;
                q.add(new Node(num, num, count + 1)); // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
            }

            if (cb != 0 && num + cb <= 2000 && !visited[num + cb][cb]) {
                visited[num + cb][cb] = true;
                q.add(new Node(num + cb, cb, count + 1)); // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
            }

            if (num > 0 && !visited[num - 1][cb]) {
                visited[num - 1][cb] = true;
                q.add(new Node(num - 1, cb, count + 1)); // 화면에 있는 이모티콘 중 하나를 삭제한다.
            }

        }

    }

    public static class Node {
        int num;
        int cb;
        int count;

        public Node(int num, int cb, int count) {
            this.num = num;
            this.cb = cb;
            this.count = count;
        }
    }

}
