import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = 3;
        StringBuilder sb = new StringBuilder("");
        while (testCase-->0) {
            int N = Integer.parseInt(br.readLine());
            BigInteger sum = new BigInteger("0");
            for (int i = 0; i < N; i ++) {
                sum = sum.add(BigInteger.valueOf(Long.parseLong(br.readLine())));
            }
            if (sum.compareTo(BigInteger.valueOf(0L)) > 0) {
                sb.append("+").append("\n");
            } else if (sum.compareTo(BigInteger.valueOf(0L)) < 0) {
                sb.append("-").append("\n");
            } else {
                sb.append("0").append("\n");
            }
        }
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}
