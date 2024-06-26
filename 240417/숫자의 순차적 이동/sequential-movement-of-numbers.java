// import java.util.*;
// import java.io.*;

// public class Main {
//     public static class Point {
//         int y, x;
        
//         Point() {
//             this.y = -1;
//             this.x = -1;
//         }

//         Point(int y, int x) {
//             this.y = y;
//             this.x = x;
//         }
//     }
//     public static int[][] direction = { {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, 1} };
//     public static int[][] boards;
//     public static int n, m;
//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         HashMap<Integer, Point> numInfo = new HashMap<>();
//         n = Integer.parseInt(st.nextToken());
//         m = Integer.parseInt(st.nextToken());

//         boards = new int[n][n];

//         for (int i = 0; i < n; i++) {
//             st = new StringTokenizer(br.readLine());
//             for (int j = 0; j < n; j++) {
//                 boards[i][j] = Integer.parseInt(st.nextToken());
//                 numInfo.put(boards[i][j], new Point(i, j));
//             }
//         }

//         for (int turn = 0; turn < m; turn++) {
//             for (int i = 1; i <= n * n; i++) {
//                 Point p = numInfo.get(i);
//                 int maxNum = 0;
//                 Point maxP = new Point();
//                 for (int[] d: direction) {
//                     int ny = p.y + d[0];
//                     int nx = p.x + d[1];

//                     if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;
//                     if (boards[ny][nx] > maxNum) {
//                         maxNum = boards[ny][nx];
//                         maxP = numInfo.get(boards[ny][nx]);
//                     } 
//                 }

//                 boards[maxP.y][maxP.x] = boards[p.y][p.x];
//                 boards[p.y][p.x] = maxNum;
//                 System.out.println(boards[maxP.y][maxP.x] + " " + boards[p.y][p.x] + " " + maxNum);
//                 numInfo.put(boards[p.y][p.x], new Point(maxP.y, maxP.x));
//                 numInfo.put(boards[maxP.y][maxP.x], new Point(p.y, p.x));
//                 // Point tmp = new Point(p.y, p.x);
//                 // p.y = maxP.y;
//                 // p.x = maxP.x;
//                 // maxP.y = tmp.y;
//                 // maxP.x = tmp.x;
//             }
//         }

//         print();
//     }

//     public static void print() {
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 sb.append(boards[i][j]).append(" ");
//             }

//             sb.append("\n");
//         }

//         System.out.println(sb);
//     }
// }

import java.util.Scanner;

class Pair { 
    int x, y;
    public Pair(int x, int y) { 
        this.x = x; 
        this.y = y; 
    } 
}

public class Main {
    public static final int DIR_NUM = 8;
    public static final int MAX_N = 20;
    
    public static int n, m;
    public static int[][] grid = new int[MAX_N][MAX_N];
    
    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
    
    public static Pair FindPos(int num) {
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == num)
                    return new Pair(i, j);
        
        return new Pair(0, 0);
    }
    
    // 그 다음 위치를 찾아 반환합니다.
    public static Pair NextPos(Pair pos) {
        int[] dx = new int[]{-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dy = new int[]{ -1, 0,  1, -1, 1, -1, 0, 1};
        
        int x = pos.x;
        int y = pos.y;
        
        // 인접한 8개의 칸 중 가장 값이 큰 위치를 찾아 반환합니다.
        int maxVal = -1;
        Pair maxPos = new Pair(0, 0);
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if(inRange(nx, ny) && grid[nx][ny] > maxVal) {
                maxVal = grid[nx][ny];
                maxPos = new Pair(nx, ny);
            }
        }
        
        return maxPos;
    }
    
    public static void swap(Pair pos, Pair nextPos) {
        int x = pos.x;
        int y = pos.y;
        
        int nx = nextPos.x;
        int ny = nextPos.y;
    
        int temp = grid[x][y];
        grid[x][y] = grid[nx][ny];
        grid[nx][ny] = temp;
    }
    
    public static void simulate() {
        // 번호가 증가하는 순으로
        // 그 다음 위치를 구해
        // 한 칸씩 움직입니다.
        for(int num = 1; num <= n * n; num++) {
            Pair pos = FindPos(num);
            Pair nextPos = NextPos(pos);
            swap(pos, nextPos);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
            
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        // m번 시뮬레이션을 진행합니다.
        while(m-- > 0)
            simulate();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                System.out.print(grid[i][j] + " ");
            System.out.println();
        }
    }
}