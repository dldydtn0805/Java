// https://www.acmicpc.net/problem/1730

/*해설

로봇팔이 지나지 않은 점은 '.'으로,

로봇팔이 수직 방향으로만 지난 점은 '|'

로봇팔이 수평 방향으로만 지난 점은 '-'

수직 수평 모두 지난 점은 '+'로 표기하라.

N은 목판의 크기이다.

시작 위치는 맨 왼쪽 위의 꼭지점이다.

격자 바깥으로 나가는 움직임은 무시하고 다음 명령을 진행한다.

주의할 점은, 비어있는 명령이 있을 수 있다는 것이다.
*/

/*입력
2
RR
*/

/*출력
|..|.
++.|.
.+-+.
.....
.....
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N =  Integer.parseInt(br.readLine());
        String[] order = br.readLine().split("");

        Map<String, List<Integer>> directions = new HashMap<>();
        directions.put("U", Arrays.asList(-1, 0));
        directions.put("D", Arrays.asList(1, 0));
        directions.put("R", Arrays.asList(0,1));
        directions.put("L", Arrays.asList(0,-1));

        int[][] maps = new int[N][N];
        int ci = 0, cj = 0;
        try {
            for (int i = 0; i < order.length; i++) {
                int di = directions.get(order[i]).get(0), dj = directions.get(order[i]).get(1);
                int ni = ci+di, nj = cj+dj;
                if (0 <= ni && ni < N && 0 <= nj && nj < N) {
                    if (order[i].equals("U") || order[i].equals("D")) {
                        maps[ci][cj] |= 1 << 1;
                        maps[ni][nj] |= 1 << 1;
                    } else {
                        maps[ci][cj] |= 1 << 2;
                        maps[ni][nj] |= 1 << 2;
                    }
                    ci = ni; cj = nj;
                }
            }
        } catch (Exception e) {
        }
        for (int i = 0; i < N; i ++ ) {
            for (int j = 0; j < N; j++) {
                int cur = maps[i][j];
                if (cur == 2) {
                    bw.write("|");
                } else if (cur == 4) {
                    bw.write("-");
                } else if (cur == 6) {
                    bw.write("+");
                } else {
                    bw.write(".");
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

/*
 * */
