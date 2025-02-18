import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static List<int[]> door = new ArrayList<>();
    public static char[][] map;
    public static boolean[][][] visited;
    public static int[] dx = { 0, 0, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        visited = new boolean[2][N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == '#') {
                    door.add(new int[] { i, j });
                }
            }
        }

        bfs();
    }

    public static void bfs() {
        Queue<Node> q = new LinkedList<>();
        int[] start = door.get(0);
        int[] end = door.get(1);

        q.offer(new Node(start[0], start[1], 0, 0));
        q.offer(new Node(start[0], start[1], 1, 0));
        visited[0][start[0]][start[1]] = true;
        visited[0][start[1]][start[1]] = true;

        while (!q.isEmpty()) {
            Node n = q.poll();
            int x = n.x;
            int y = n.y;
            int dir = n.dir;
            int num = n.num;

            // 가로 계산
            if (dir == 0) {
                for (int i = 0; i < 2; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    while (true) {
                        if (cx == end[0] && cy == end[1]) {
                            System.out.print(num);
                            System.exit(0);
                            return;
                        }

                        if (cx < 0 || cy < 0 || cx >= N || cy >= N)
                            break;
                        if (map[cx][cy] == '*')
                            break;
                        if (visited[0][cx][cy])
                            break;

                        visited[0][cx][cy] = true;
                        if (map[cx][cy] == '!') {
                            q.offer(new Node(cx, cy, 1, num + 1));
                        }

                        cx += dx[i];
                        cy += dy[i];
                    }
                }
            }

            // 세로 계산
            if (dir == 1) {
                for (int i = 2; i < 4; i++) {
                    int cx = x + dx[i];
                    int cy = y + dy[i];

                    while (true) {
                        if (cx == end[0] && cy == end[1]) {
                            System.out.print(num);
                            System.exit(0);
                            return;
                        }

                        if (cx < 0 || cy < 0 || cx >= N || cy >= N)
                            break;
                        if (map[cx][cy] == '*')
                            break;
                        if (visited[1][cx][cy])
                            break;

                        visited[1][cx][cy] = true;
                        if (map[cx][cy] == '!') {
                            q.offer(new Node(cx, cy, 0, num + 1));
                        }

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
