import java.util.*;
import java.io.*;

public class Main {
    public static int[] list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            switch (command) {
                case '0':
                    union(a, b);
                    break;
                
                case '1':
                    if (find(a) == find(b)) sb.append("1");
                    else sb.append("0");

                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void union(int y, int x) {
        int Y = find(y);
        int X = find(x);
        list[X] = Y;
    }

    public static int find(int x) {
        if (list[x] == x) return x;
        int parent = find(list[x]);
        list[x] = parent;
        return parent;
    }
}