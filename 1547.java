import java.math.*;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int cur = 1;
        for (int i = 0; i < M; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (cur == from) {
                cur = to;
            } else if (cur == to) {
                cur = from;
            }
        }
        System.out.println(cur);
        br.close();
    }
}
