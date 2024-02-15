import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> numbers = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = A + B;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            if (numbers.contains(Integer.parseInt(st.nextToken()))) {
                answer -= 2;
            }
        }

        System.out.println(answer);
    }
}