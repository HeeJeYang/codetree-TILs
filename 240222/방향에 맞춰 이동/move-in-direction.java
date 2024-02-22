import java.util.*;
import java.io.*;

public class Main {
    public static class Point {
        int y, x;

        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] direction = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
        Point point = new Point(0, 0);
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            int dist = Integer.parseInt(st.nextToken());
            switch(command) {
                case 'N':
                    point.y += dist;
                    break;
                case 'E':
                    point.x += dist;
                    break;
                case 'W':
                    point.x -= dist;
                    break;
                case 'S':
                    point.y -= dist;
                    break;
                default:
                    break;
            }
        }

        System.out.println(point.x + " " + point.y);
    }
}