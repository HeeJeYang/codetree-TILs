import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, Integer> numbers = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int k = Integer.parseInt(st.nextToken());

            switch (command) {
                case "add":
                    numbers.put(k, Integer.parseInt(st.nextToken()));
                    break;
                
                case "remove":
                    numbers.remove(k);
                    break;

                case "find":
                    sb.append(numbers.containsKey(k) ? numbers.get(k) : "None").append("\n");
                    break;

                default:
                    break;
            }
        }

        System.out.println(sb);
    }
}