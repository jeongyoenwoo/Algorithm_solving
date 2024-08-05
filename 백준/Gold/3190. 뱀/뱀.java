import java.util.*;
import java.io.*;

public class Main {

    public static int N, K, L;
    public static char C;
    public static int[][] map;
    public static List<Node> snake = new ArrayList<>();
    public static HashMap<Integer, String> hash = new HashMap<>();
    public static int[] dx = { 0, 1, 0, -1 };
    public static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String direction = st.nextToken();

            hash.put(time, direction);
        }

        play();
    }

    public static void play() {
        int cx = 1, cy = 1;
        int time = 0;
        int direction = 0;
        snake.add(new Node(1, 1));

        while (true) {
            // 1. 시간 재기
            time++;

            // 2. 뱀 이동하기
            int nx = cx + dx[direction];
            int ny = cy + dy[direction];

            // 3. 뱀이 범위를 벗어나거나 몸통에 부딪히는지 확인
            if (isFinish(nx, ny))
                break;

            // 4. 사과 여부에 따라 로직 진행
            if (map[nx][ny] == 1) {
                map[nx][ny] = 0;
                snake.add(new Node(nx, ny));
            } else {
                snake.add(new Node(nx, ny));
                snake.remove(0);
            }

            // 5. 방향 변화가 있는 시간대면 direction 값 변화
            if (hash.containsKey(time)) {
                if (hash.get(time).equals("D")) {
                    direction++;
                    if (direction == 4)
                        direction = 0;
                } else {
                    direction--;
                    if (direction == -1)
                        direction = 3;
                }
            }

            // 6. 현재 값 업데이트
            cx = nx;
            cy = ny;
        }

        System.out.println(time);
    }

    public static boolean isFinish(int nx, int ny) {
        if (nx <= 0 || ny <= 0 || nx > N || ny > N) {
            return true;
        }

        for (int i = 0; i < snake.size(); i++) {
            Node node = snake.get(i);
            if (node.x == nx && node.y == ny)
                return true;
        }
        return false;
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
