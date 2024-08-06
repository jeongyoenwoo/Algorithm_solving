import java.util.*;
import java.io.*;

public class Main {

    public static int N, M;
    public static int[][] map;
    public static Fish shark;
    public static int eat = 2;
    public static int time = 0;
    public static int[] dx = { -1, 0, 0, 1 };
    public static int[] dy = { 0, -1, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                if (a != 0) {
                    if (a == 9) {
                        shark = new Fish(i, j, 2);
                        map[i][j] = 0;
                    }
                }
            }
        }

        while (true) {
            if (!findFish(shark.x, shark.y))
                break;
        }

        System.out.println(time);
    }

    public static boolean findFish(int sharkX, int sharkY) {

        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new Node(sharkX, sharkY, 0));
        visited[sharkX][sharkY] = true;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int minTime = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int time = node.time;

            // 기존의 최단 시간보다 더 긴 시간이 되면 종료
            if (time >= minTime)
                break;

            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx < 0 || cy < 0 || cx >= N || cy >= N)
                    continue;

                if (visited[cx][cy])
                    continue;

                if (map[cx][cy] > shark.weight)
                    continue;

                // 다음 칸에 먹을 수 있는 물고기가 있는 경우
                if (map[cx][cy] != 0 && map[cx][cy] < shark.weight) {

                    if (cx < minX) {
                        minX = cx;
                        minY = cy;
                        minTime = time + 1;
                    } else if (cx == minX) {
                        if (cy < minY) {
                            minY = cy;
                            minTime = time + 1;
                        }
                    }

                }

                visited[cx][cy] = true;
                q.offer(new Node(cx, cy, time + 1));
            }
        }

        if (minTime == Integer.MAX_VALUE)
            return false;
        else {
            map[minX][minY] = 0;
            shark.x = minX;
            shark.y = minY;
            time += minTime;

            eat--;
            if (eat == 0) {
                shark.weight++;
                eat = shark.weight;
            }
            return true;
        }
    }

    public static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static class Fish {
        int x;
        int y;
        int weight;

        public Fish(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

}
