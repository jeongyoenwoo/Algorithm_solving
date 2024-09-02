import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long sum;
    static List<House> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long pos = Long.parseLong(st.nextToken());
            long num = Long.parseLong(st.nextToken());

            list.add(new House(pos, num));
            sum += num;
        }

        Collections.sort(list);

        long result = 0;

        for (int i = 0; i < N; i++) {
            House h = list.get(i);
            result += h.num;
            if ((sum + 1) / 2 <= result) {
                System.out.println(h.pos);
                break;
            }
        }
    }

    public static class House implements Comparable<House> {
        long pos;
        long num;

        public House(long pos, long num) {
            this.pos = pos;
            this.num = num;
        }

        @Override
        public int compareTo(House h) {
            return (int) (this.pos - h.pos);
        }
    }

}