import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static boolean[] broken;
    public static List<Egg> list = new ArrayList<>();
    public static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        broken = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int shield = Integer.parseInt(st.nextToken());
            int power = Integer.parseInt(st.nextToken());

            list.add(new Egg(shield, power));
        }

        dfs(0);

        System.out.println(max);
    }

    public static void dfs(int cur) {
        boolean check = false;

        if (cur == N) {
            int num = 0;
            for (Egg e : list) {
                if (e.shield <= 0)
                    num++;
            }

            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i != cur && list.get(cur).shield > 0 && list.get(i).shield > 0) {
                check = true;
                list.get(i).shield -= list.get(cur).power;
                list.get(cur).shield -= list.get(i).power;
                dfs(cur + 1);
                list.get(i).shield += list.get(cur).power;
                list.get(cur).shield += list.get(i).power;
            }
        }

        if (!check)
            dfs(cur + 1);
    }

    public static class Egg {
        int shield;
        int power;

        public Egg(int shield, int power) {
            this.shield = shield;
            this.power = power;
        }
    }

}
