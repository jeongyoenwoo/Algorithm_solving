import java.io.*;
import java.util.*;

public class Main {

    public static int R, C;
    public static char[][] map;
    public static Node start;
    public static Queue<Node> fires = new LinkedList<>();
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = str.charAt(j);
                map[i][j] = c;

                if (c == 'J')
                    start = new Node(i, j);
                if (c == 'F')
                    fires.offer(new Node(i, j));
            }
        }

        bfs();

        System.out.println("IMPOSSIBLE");

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        int time = 1;

        while (!q.isEmpty()) {
            int len = fires.size();

            for (int t = 0; t < len; t++) {
                Node fire = fires.poll();
                int x = fire.x;
                int y = fire.y;

                for (int i = 0; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    if (cx < 0 || cy < 0 || cx >= R || cy >= C)
                        continue;

                    if (map[cx][cy] == '#' || map[cx][cy] == 'F')
                        continue;

                    map[cx][cy] = 'F';
                    fires.offer(new Node(cx, cy));
                }
            }

            len = q.size();
            for (int t = 0; t < len; t++) {
                Node current = q.poll();
                int x = current.x;
                int y = current.y;

                for (int i = 0; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    if (cx < 0 || cy < 0 || cx >= R || cy >= C) {
                        System.out.println(time);
                        System.exit(0);
                    }

                    if (map[cx][cy] == '#' || map[cx][cy] == 'F' || map[cx][cy] == 'J')
                        continue;

                    map[cx][cy] = 'J';
                    q.offer(new Node(cx, cy));
                }
            }

            time++;
        }

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
