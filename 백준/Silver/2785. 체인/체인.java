import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    private void solution() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] array = new int[count];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            deque.offer(array[i]);
        }

        int result = 0;
        while (deque.size() > 1) {
            result++;
            int number1 = deque.pollLast();
            int number2 = deque.pollLast();
            deque.offerLast(number1 + number2);

            if (deque.size() >= 2) {
                int number = deque.pollFirst();
                if (number > 1) {
                    deque.offerFirst(number - 1);
                }
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}