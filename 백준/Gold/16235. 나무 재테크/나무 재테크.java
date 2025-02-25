import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, K;
    public static int[][] map;
    public static int[][] A;
    public static int[] dx = { 0, 0, 1, -1, 1, -1, 1, -1 };
    public static int[] dy = { 1, -1, 0, 0, 1, -1, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        A = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        Queue<Tree> pq = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            pq.offer(new Tree(r, c, age));
        }
        Collections.sort((List<Tree>) pq);

        Queue<Tree> live = new LinkedList<>();
        Queue<Tree> die = new LinkedList<>();

        while (K > 0) {
            // 봄
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Tree t = pq.poll();
                if (t.age <= map[t.r][t.c]) {
                    pq.offer(new Tree(t.r, t.c, t.age + 1));
                    map[t.r][t.c] -= t.age;
                } else {
                    die.offer(new Tree(t.r, t.c, t.age));
                }
            }

            // 여름
            while (!die.isEmpty()) {
                Tree t = die.poll();
                map[t.r][t.c] += (t.age) / 2;
            }

            // 가을
            size = pq.size();
            for (int s = 0; s < size; s++) {
                Tree t = pq.poll();
                live.offer(t);

                if (t.age % 5 == 0) {
                    for (int i = 0; i < 8; i++) {
                        int cr = t.r + dx[i];
                        int cc = t.c + dy[i];

                        if (cr <= 0 || cc <= 0 || cr > N || cc > N)
                            continue;

                        pq.offer(new Tree(cr, cc, 1));

                    }
                }
            }

            while (!live.isEmpty()) {
                Tree t = live.poll();
                pq.offer(t);
            }

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    map[i][j] += A[i][j];
                }
            }

            K--;
        }

        System.out.println(pq.size());
    }

    public static class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;

        public Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree t) {
            return this.age - t.age;
        }
    }
}
