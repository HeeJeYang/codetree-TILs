import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int A = Integer.parseInt(st.nextToken());
                    pq.add(-A);
                    break;
                
                case "size":
                    sb.append(pq.size()).append("\n");
                    break;
                
                case "pop":
                    sb.append(-pq.poll()).append("\n");
                    break;
                
                case "empty":
                    sb.append(pq.isEmpty() ? 1 : 0).append("\n");
                    break;

                case "top":
                    sb.append(-pq.peek()).append("\n");
            }
        }

        System.out.println(sb);
    }
}