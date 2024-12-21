import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] files = new String[N];

        for (int i = 0; i < N; i++) {
            files[i] = br.readLine();
        }

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String key = "";
            char[] arr = files[i].toCharArray();
            boolean check = false;

            for (char c : arr) {
                if (check) {
                    key += c;
                }
                if (c == '.')
                    check = true;
            }

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        for (String key : list) {
            System.out.print(key);
            System.out.print(" ");
            System.out.println(map.get(key));
        }

    }

}
