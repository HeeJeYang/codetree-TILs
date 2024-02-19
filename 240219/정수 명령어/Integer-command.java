import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        TreeSet<Integer> numbers = new TreeSet<>();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                char command = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());
                switch (command) {
                    case 'I':
                        numbers.add(n);
                        break;
                    
                    case 'D':
                        if (numbers.isEmpty()) break;
                        if (n == 1) numbers.pollLast();
                        if (n == -1) numbers.pollFirst();
                        break;

                    default:
                        break;
                }
            }

            if (numbers.isEmpty()) sb.append("EMPTY");
            else sb.append(numbers.last()).append(" ").append(numbers.first());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}