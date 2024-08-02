import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static char[][] map;
    public static int[] dx = { 0, 0, -1, 1 };
    public static int[] dy = { -1, 1, 0, 0 };
    public static Coin[] coin = new Coin[2];
    public static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int coinIdx = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'o')
                    coin[coinIdx++] = new Coin(i, j);
            }
        }

        visited = new boolean[N][M][N][M];

        System.out.println(bfs());
    }

    public static int bfs() {

        Queue<twoCoins> q = new LinkedList<>();
        q.add(new twoCoins(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;

        while (!q.isEmpty()) {
            twoCoins current = q.poll();

            if (current.count >= 10)
                break;

            for (int i = 0; i < 4; i++) {
                int cx1 = current.x1 + dx[i];
                int cy1 = current.y1 + dy[i];
                int cx2 = current.x2 + dx[i];
                int cy2 = current.y2 + dy[i];

                if (cx1 >= 0 && cy1 >= 0 && cx1 < N && cy1 < M && map[cx1][cy1] == '#') {
                    cx1 = current.x1;
                    cy1 = current.y1;
                }

                if (cx2 >= 0 && cy2 >= 0 && cx2 < N && cy2 < M && map[cx2][cy2] == '#') {
                    cx2 = current.x2;
                    cy2 = current.y2;
                }

                int num = 0; // 떨어지지 않는 동전의 개수

                if (cx1 >= 0 && cy1 >= 0 && cx1 < N && cy1 < M)
                    num++;
                if (cx2 >= 0 && cy2 >= 0 && cx2 < N && cy2 < M)
                    num++;

                if (num == 1)
                    return current.count + 1;
                else if (num == 2 && !visited[cx1][cy1][cx2][cy2]) {
                    visited[cx1][cy1][cx2][cy2] = true;
                    q.add(new twoCoins(cx1, cy1, cx2, cy2, current.count + 1));
                }

            }

        }

        return -1;
    }

    public static class Coin {
        int x;
        int y;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class twoCoins {
        int x1;
        int y1;
        int x2;
        int y2;
        int count;

        public twoCoins(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }

}
