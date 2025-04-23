import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken()), W = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());

        System.out.println(Math.min(X, Math.min(Math.abs(W-X), Math.min(Y,Math.abs(H-Y)))));

    }

}
