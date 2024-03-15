import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Math.min(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        answer = Math.min(answer, Integer.parseInt(st.nextToken()));
        System.out.println(answer);
    }
}