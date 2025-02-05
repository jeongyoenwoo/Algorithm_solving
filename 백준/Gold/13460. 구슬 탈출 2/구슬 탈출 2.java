import java.io.*;
import java.util.*;

public class Main {

    public static int N, M;
    public static char[][] map;
    public static boolean[][][][] visited;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static Node start;
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (map[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        start = new Node(rx, ry, bx, by, 0);
        visited[rx][ry][bx][by] = true;

        bfs();

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            Node n = q.poll();
            int cnt = n.cnt;

            if (cnt >= 10)
                return;

            for (int i = 0; i < 4; i++) {
                int rx = n.rx;
                int ry = n.ry;
                int bx = n.bx;
                int by = n.by;

                while (map[rx + dx[i]][ry + dy[i]] != '#') {
                    rx += dx[i];
                    ry += dy[i];

                    if (map[rx][ry] == 'O')
                        break;
                }

                while (map[bx + dx[i]][by + dy[i]] != '#') {
                    bx += dx[i];
                    by += dy[i];

                    if (map[bx][by] == 'O')
                        break;
                }

                if (map[bx][by] == 'O')
                    continue;

                if (map[rx][ry] == 'O') {
                    min = Math.min(min, cnt + 1);
                    return;
                }

                if (rx == bx && ry == by && map[rx][ry] != 'O') {
                    int redMove = Math.abs(rx - n.rx) + Math.abs(ry - n.ry);
                    int blueMove = Math.abs(bx - n.bx) + Math.abs(by - n.by);

                    if (redMove > blueMove) {
                        rx -= dx[i];
                        ry -= dy[i];
                    } else {
                        bx -= dx[i];
                        by -= dy[i];
                    }
                }

                if (!visited[rx][ry][bx][by]) {
                    visited[rx][ry][bx][by] = true;
                    q.offer(new Node(rx, ry, bx, by, cnt + 1));
                }

            }
        }

    }

    public static class Node {
        int rx;
        int ry;
        int bx;
        int by;
        int cnt;

        public Node(int rx, int ry, int bx, int by, int cnt) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.cnt = cnt;
        }
    }

}
