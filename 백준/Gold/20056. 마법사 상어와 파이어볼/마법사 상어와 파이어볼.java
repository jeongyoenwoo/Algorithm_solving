import java.io.*;
import java.util.*;

public class Main {

    public static int N, M, K;
    public static List<Fireball>[][] map;
    public static List<Fireball> list = new ArrayList<>();
    public static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
    public static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Fireball(r, c, m, s, d));
            map[r][c].add(new Fireball(r, c, m, s, d));
        }

        for (int k = 0; k < K; k++) {

            fireballMove();

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j].size() >= 2) {
                        fireballDivide(i, j, map[i][j]);
                    }
                }
            }
            cleanList();
        }

        int answer = 0;

        for (Fireball fireball : list) {
            answer += fireball.m;
        }

        System.out.print(answer);
    }

    public static void cleanList() {
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j].size() > 0) {
                    for (Fireball fireball : map[i][j]) {
                        list.add(fireball);
                    }
                }
            }
        }
    }

    public static void fireballMove() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (Fireball fireball : list) {
            int nr = fireball.r + dr[fireball.d] * (fireball.s % N);
            int nc = fireball.c + dc[fireball.d] * (fireball.s % N);

            if (nr <= 0)
                nr += N;
            if (nc <= 0)
                nc += N;
            if (nr > N)
                nr -= N;
            if (nc > N)
                nc -= N;

            fireball.r = nr;
            fireball.c = nc;
            map[nr][nc].add(fireball);
        }
    }

    public static void fireballDivide(int r, int c, List<Fireball> balls) {

        int mSum = 0;
        int sSum = 0;
        boolean odd = true;
        boolean even = true;

        for (Fireball fireball : balls) {
            mSum += fireball.m;
            sSum += fireball.s;

            if (fireball.d % 2 == 0) {
                odd = false;
            } else {
                even = false;
            }
        }

        int nm = mSum / 5;
        int ns = sSum / balls.size();

        map[r][c] = new ArrayList<>();
        if (nm <= 0)
            return;

        if (!odd && !even) {
            map[r][c].add(new Fireball(r, c, nm, ns, 1));
            map[r][c].add(new Fireball(r, c, nm, ns, 3));
            map[r][c].add(new Fireball(r, c, nm, ns, 5));
            map[r][c].add(new Fireball(r, c, nm, ns, 7));
        } else {
            map[r][c].add(new Fireball(r, c, nm, ns, 0));
            map[r][c].add(new Fireball(r, c, nm, ns, 2));
            map[r][c].add(new Fireball(r, c, nm, ns, 4));
            map[r][c].add(new Fireball(r, c, nm, ns, 6));
        }

    }

    public static class Fireball {
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fireball(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

}
