// https://www.acmicpc.net/problem/22935

/*해설
이진딸기의 규칙 다음과 같다

4박자를 사용하며, 1~15의 수를 이진법으로 나타내어 0에서는 박자를 비우고 1에서만 딸기를 외치게 된다.

비는 박자는 V를 사용하여 나타낸다

T개의 줄에 걸쳐 이진 딸기를 처음 시작한 사람으로부터, 몇차례 후에 해강이가 말해야하는지 N이 정수로 주어진다.

해강이가 해야하는 말은 ? 쉬는 박자는 V로 한다.
*/

/*입력
2
3
16
*/

/*출력
VV딸기딸기
딸기딸기딸기V
 */

import java.io.*;
import java.util.*;

public class Main {
    static String[] strawberries = {
            "VVV딸기",
            "VV딸기V",
            "VV딸기딸기",
            "V딸기VV",
            "V딸기V딸기",
            "V딸기딸기V",
            "V딸기딸기딸기",
            "딸기VVV",
            "딸기VV딸기",
            "딸기V딸기V",
            "딸기V딸기딸기",
            "딸기딸기VV",
            "딸기딸기V딸기",
            "딸기딸기딸기V",
            "딸기딸기딸기딸기",
            "딸기딸기딸기V",
            "딸기딸기V딸기",
            "딸기딸기VV",
            "딸기V딸기딸기",
            "딸기V딸기V",
            "딸기VV딸기",
            "딸기VVV",
            "V딸기딸기딸기",
            "V딸기딸기V",
            "V딸기V딸기",
            "V딸기VV",
            "VV딸기딸기",
            "VV딸기V",
    };
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for (int tc = 0; tc < T; tc++) {
            long N = Long.parseLong(br.readLine());
            int idx = (int) ((N-1)%28L);
            sb.append(strawberries[idx]).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }


}
