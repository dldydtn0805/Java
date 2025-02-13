// https://www.acmicpc.net/problem/1182

/*해설
배열 A를 오름차순으로 만드는데 필요한 최소한의 횟수는 ?
*/

/*입력
5 0
-7 -3 -2 5 8
 */

/*출력
1
 */

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), S = Integer.parseInt(st.nextToken());
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 1; i < (1 << N); i ++) {
            int sumV = 0;
            int j = 0;
//            LinkedList<Integer> tmp = new LinkedList<>();
            while ((1 << j) <= i) {
                if ((i & (1 << j)) == (1 << j)) {
                    sumV += A[j];
//                    tmp.add(j);
                }
                j++;
            }
//            System.out.println(tmp);
            if (sumV == S) {
                cnt++;
            }
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }
}
