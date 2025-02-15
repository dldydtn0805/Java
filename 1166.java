// https://www.acmicpc.net/problem/1166

/*해설
민식이는 아이들에게 선물할 같은 크기의 작은 박스 N개를 가지고 있다.

모든 박스는 정육면체이고 A*A*A 크기이다.

이 박스들을 L * W * H인 직육면체 박스에 넣으려고 한다.
*/

/*입력
10 4 2 10
 */

/*출력
2.0
 */

import java.io.*;
import java.util.*;

public class Main {
    static long e = (long) Math.pow(10, 9);
    static long N, L, W, H;
    static long minV = 1L;
    static long maxV = 1000000000*e;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        L = Long.parseLong(st.nextToken()) * e;
        W = Long.parseLong(st.nextToken()) * e;
        H = Long.parseLong(st.nextToken()) * e;
        double ans = (double) binarySearch(minV, maxV) / (double) e;
        bw.write(String.format("%.15f", ans));
        bw.close();
        br.close();
    }

    public static boolean getCheck (long m) {
        if (L < m || W < m || H < m) return false;
        return (L/m) * (W/m) * (H/m) >= N;
    }
    public static long binarySearch (long l, long r) {
        long res = 0;
        while (l <= r) {
            long m = (l+r)/2L;
            if (getCheck(m)) {
//                System.out.println(m);
                res = Math.max(res, m);
                l = m + 1L;
            } else {
                r = m - 1L;
            }
        }
        return res;
    }
}

/*
 * */
