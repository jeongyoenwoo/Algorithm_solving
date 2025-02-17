import java.io.*;
import java.util.*;

public class Main {

    public static int W, H;
    public static char[][] map;
    public static boolean[][][] visited;
    public static List<int[]> list = new ArrayList<>();
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };
    public static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        visited = new boolean[H][W][2];

        for (int i = 0; i < H; i++) {
            String str = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'C') {
                    list.add(new int[] { i, j });
                }
            }
        }

        bfs();

    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        int[] start = list.get(0);
        int[] end = list.get(1);
        q.offer(new Node(start[0], start[1], 0, 0));
        q.offer(new Node(start[0], start[1], 1, 0));
        visited[start[0]][start[1]][0] = true;
        visited[start[0]][start[1]][1] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y = n.y;
            int dir = n.dir;
            int num = n.num;

            if (num > min)
                continue;

            if (x == end[0] && y == end[1]) {
                System.out.print(num - 1);
                System.exit(0);
                return;
            }

            // 가로 이동
            if (dir == 0) {
                for (int i = 0; i < 2; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];
                    int cNum = num + 1;

                    while (true) {
                        if (cx < 0 || cy < 0 || cx >= H || cy >= W)
                            break;
                        if (map[cx][cy] == '*')
                            break;
                        if (visited[cx][cy][0])
                            break;

                        visited[cx][cy][0] = true;
                        q.offer(new Node(cx, cy, 1, cNum));
                        cx += dx[i];
                        cy += dy[i];
                    }

                }
            }

            // 세세로 이동
            if (dir == 1) {
                for (int i = 2; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];
                    int cNum = num + 1;

                    while (true) {
                        if (cx < 0 || cy < 0 || cx >= H || cy >= W)
                            break;
                        if (map[cx][cy] == '*')
                            break;
                        if (visited[cx][cy][1])
                            break;

                        visited[cx][cy][1] = true;
                        q.offer(new Node(cx, cy, 0, cNum));
                        cx += dx[i];
                        cy += dy[i];
                    }

                }
            }

        }

    }

    public static class Node {
        int x;
        int y;
        int dir;
        int num;

        public Node(int x, int y, int dir, int num) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.num = num;
        }
    }

}
