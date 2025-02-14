// https://www.acmicpc.net/problem/19947

/*해설
int 형변환에 대한 문제이다.
*/

/*입력
95229 3
 */

/*출력
114274
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()), Y = Integer.parseInt(st.nextToken());
        int[] gain = new int[Y+1];
        gain[0] = H;
        for (int i = 1; i < Y+1; i++) {
            int A = i-1, B = i-3, C = i-5;
            if (0 <= C) {
                gain[i] = (int) Math.max(gain[A]*1.05, Math.max(gain[B]*1.2, gain[C]*1.35));
            } else if (0 <= B) {
                gain[i] = (int) Math.max(gain[A]*1.05, gain[B]*1.2);
            } else {
                gain[i] = (int) (gain[i-1]*1.05);
            }
        }
        bw.write(String.valueOf(gain[Y]));
        bw.close();
        br.close();
    }
}

/*
 * */
