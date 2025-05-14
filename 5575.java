import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 3; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startH = Integer.parseInt(st.nextToken());
            int startM = Integer.parseInt(st.nextToken());
            int startS = Integer.parseInt(st.nextToken());
            int endH = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            int endS = Integer.parseInt(st.nextToken());
            int total = endH*3600 + endM*60 + endS - (startH*3600 + startM*60 + startS);
            int H = total / 3600;
            int M = (total % 3600) / 60;
            int S = (total % 3600) % 60;
            System.out.println(H + " " + M + " " + S);
        }
        bw.close();
        br.close();
    }

}
