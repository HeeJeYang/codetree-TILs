import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int answer = 0;
    public static int[][] direction = { {-1, 0}, {0, -1}, {1, 0}, {0, 1} };
    public static char[][] matrix;
    public static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        // 여기에 코드를 작성해주세요.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        matrix = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String brackets = br.readLine();
            for (int j = 0; j < N; j++) {
                matrix[i][j] = brackets.charAt(j);
            }
        }

        dfs(0, 0, 0, 0);

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int left, int right) {
        if (right != 0 && left <= answer / 2) {
            return;
        }
        if (right != 0 && left == right) {
            answer = right * 2;
            return;
        }

        for (int[] d: direction) {
            int ny = y + d[0];
            int nx = x + d[1];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;
            if (right != 0 && matrix[ny][nx] == '(') continue;
            if (left == 0 && matrix[ny][nx] == ')') continue;

            visited[ny][nx] = true;

            if (matrix[ny][nx] == '(') {
                dfs(ny, nx, left + 1, right);
            } else {
                dfs(ny, nx, left, right + 1);
            }

            visited[ny][nx] = false;
        }
    }
}