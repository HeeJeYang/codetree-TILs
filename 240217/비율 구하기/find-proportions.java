import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        TreeMap<String, Integer> words = new TreeMap<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.put(word, words.getOrDefault(word, 0) + 1);
        }

        Iterator<Entry<String, Integer>> it = words.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> entry = it.next();
            sb.append(entry.getKey()).append(" ").append(String.format("%.4f", (double) entry.getValue() / N * 100)).append("\n");
        }

        System.out.println(sb);
    }
}