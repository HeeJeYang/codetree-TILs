import java.util.*;
import java.io.*;

public class Main {
    public static int[][] direction = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
    public static int[][] scores, balls, movedBalls;
    public static int n, m, t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        scores = new int[n][n];
        balls = new int[n][n];
        movedBalls = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r, c;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            balls[r - 1][c - 1] = 1;
        }

        for (int i = 0; i < t; i++) {
            move();
            breakBalls();
            init();
        }

        System.out.println(count());
    }

    public static void move() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (balls[i][j] == 0) continue;

                int maxNum = -1;
                int my = 0;
                int mx = 0;
                for (int[] d: direction) {
                    int dy = i + d[0];
                    int dx = j + d[1];

                    if (dy < 0 || dy >= n || dx < 0 || dx >= n) continue;
                    if (scores[dy][dx] > maxNum) {
                        maxNum = scores[dy][dx];
                        my = dy;
                        mx = dx;
                    }
                }

                movedBalls[my][mx] += 1;
            }
        }
    }

    public static void breakBalls() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (movedBalls[i][j] == 1) balls[i][j] = 1;
                else balls[i][j] = 0;
            }
        }
    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                movedBalls[i][j] = 0;
            }
        }
    }

    public static int count() {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (balls[i][j] == 1) answer += 1;
            }
        }

        return answer;
    }
}