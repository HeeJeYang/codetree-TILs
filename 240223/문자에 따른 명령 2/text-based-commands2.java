import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String commands = br.readLine();
        int[][] direction = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        int[] point = {0, 0};
        int dirIdx = 0;

        for (int i = 0; i < commands.length(); i++) {
            char command = commands.charAt(i);
            switch (command) {
                case 'L':
                    dirIdx = (dirIdx + 3) % 4;
                    break;
                
                case 'R':
                    dirIdx = (dirIdx + 1) % 4;
                    break;
                
                case 'F':
                    point[0] += direction[dirIdx][0];
                    point[1] += direction[dirIdx][1];
                    break;

                default:
                    break;
            }
        }

        System.out.println(point[1] + " " + point[0]);
    }
}