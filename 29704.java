// https://www.acmicpc.net/problem/29704

/*해설
dp[i][j]는 i일 차에 j번 문제까지 고려했을때 피할 수 있는 최대 벌금으로 생각할 수 있다.
*/

/*입력
3 3
2 5000
1 1000
1 2000
*/

/*출력
1000
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] dp = new int[T+1][N+1];
        int[][] problems = new int[N+1][2];
        int total = 0;
        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            problems[i+1][0] = d;
            problems[i+1][1] = m;
            total += m;
        }
        for (int i = 1; i < T+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (i-problems[j][0] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], Math.max(dp[i-problems[j][0]][j-1] + problems[j][1], dp[i-1][j-1])));
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], Math.max(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        ans = total - dp[T][N];
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }


}

/*
 * */
