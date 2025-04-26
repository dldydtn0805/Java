import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder("");
        sb.append("Gnomes:").append("\n");
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());
            if ((X < Y && Y < Z) || (X > Y && Y > Z )) {
                sb.append("Ordered").append("\n");
            } 
            else {
                sb.append("Unordered").append("\n");
            }
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
  }
}
