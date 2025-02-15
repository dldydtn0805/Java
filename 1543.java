// https://www.acmicpc.net/problem/1543

/*해설
첫번째 줄에 문서가 등장한다.
둘째 줄에 검색하고 싶은 단어가 등장한다.

문서에 단어가 몇번 등장하는지 확인하라. 단, 문서의 최대 길이는 2500이다.
*/

/*입력
aaaaaaa
aa
 */

/*출력
3
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] docs = br.readLine().split("");
        String[] w = br.readLine().split("");
        int ans = 0;
        for (int i = 0; i < docs.length; i++) {
            int cnt  = 0;
            int j = 0;
            while (j <= i) {
                boolean flag = true;
                for (int k = 0; k < w.length; k++) {
                    if (j+k >= docs.length || !docs[j+k].equals(w[k])) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    cnt++;
                    j += w.length;
                } else {
                    j ++;
                }
            }
            ans = Math.max(ans, cnt);
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
}

/*
 * */
