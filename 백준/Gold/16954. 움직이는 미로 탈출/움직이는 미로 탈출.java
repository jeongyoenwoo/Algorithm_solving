import java.io.*;
import java.util.*;

public class Main {

    public static char[][] map = new char[8][8];
    public static int[] dx = { 0, 0, 0, -1, -1, -1, 1, 1, 1 };
    public static int[] dy = { 0, 1, -1, 0, -1, 1, 0, 1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 8; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        bfs();

        System.out.println(0);

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(7, 0));

        while (!q.isEmpty()) {

            boolean[][] visited = new boolean[8][8];
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Node n = q.poll();
                int x = n.x;
                int y = n.y;

                if (map[x][y] == '#')
                    continue;

                if (x == 0 && y == 7) {
                    System.out.println(1);
                    System.exit(0);
                }

                for (int i = 0; i < 9; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    if (cx < 0 || cy < 0 || cx >= 8 || cy >= 8)
                        continue;

                    if (visited[cx][cy] || map[cx][cy] == '#')
                        continue;

                    visited[cx][cy] = true;
                    q.offer(new Node(cx, cy));
                }
            }

            for (int i = 7; i > 0; i--) {
                for (int j = 0; j < 8; j++) {
                    map[i][j] = map[i - 1][j];
                }
            }

            for (int i = 0; i < 8; i++) {
                map[0][i] = '.';
            }

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
