// https://www.acmicpc.net/problem/4619

/*해설

B에 가장 가까운 A^N의 정수 A를 찾아라.
*/


/*입력
4 3
5 3
27 3
750 5
1000 5
2000 5
3000 5
1000000 5
0 0
*/

/*출력
1
2
3
4
4
4
5
16
* */

import java.io.*;
import java.util.*;

public class Main {
    static Integer INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if (B == 0 && N == 0) {
                break;
            }
            int i = 0;
            while (Math.pow(i, N) < B) {
                i++;
            }

            if (Math.pow(i, N) - B < B - Math.pow(i-1, N)) {
                System.out.println(i);
            } else {
                System.out.println(i-1);
            }
        }

    }


}

/*

 * */
