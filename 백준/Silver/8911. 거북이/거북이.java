import java.util.*;
import java.io.*;

public class Main {

    public static int T;
    public static int[] dx = { 0, -1, 0, 1 };
    public static int[] dy = { -1, 0, 1, 0 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int t = 0; t < T; t++) {
            String str = br.readLine();
            int x = 0, y = 0;
            int idx = 0;
            int hx = 0, hy = 0, lx = 0, ly = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'F') {
                    x += dx[idx];
                    y += dy[idx];
                } else if (str.charAt(i) == 'B') {
                    x -= dx[idx];
                    y -= dy[idx];

                } else if (str.charAt(i) == 'L') {
                    idx++;
                    if (idx == 4)
                        idx = 0;

                } else if (str.charAt(i) == 'R') {
                    idx--;
                    if (idx == -1)
                        idx = 3;
                }

                if (x < lx)
                    lx = x;
                if (x > hx)
                    hx = x;
                if (y < ly)
                    ly = y;
                if (y > hy)
                    hy = y;
            }

            System.out.println((hx - lx) * (hy - ly));

        }

    }

}
