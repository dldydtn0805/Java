// https://www.acmicpc.net/problem/25550

/*해설

보이는 면이란 다른 상자 또는 바닥과 닿아있지 않은 면을 말한다.

즉 안보이는 면은, 다른 상자와 닿거나, 바닥과 닿은 면이다.

포닉스는 보이는 모든 면에 붉은 색 페인트를 칠하려한다.

어떤 면에도 페인트가 칠해져 있지 않은 택배 상자의 수는 ?

모든 면이 보여지지 않은 상자이기 위해서는 다음과 같은 조건들이 필요하다.

테투리의 상자가 아니어야한다. 즉, [1~N-2][1~N-2] 범위이다.

상하좌우의 가장 낮은 높이까지 보이지 않는다고 말할 수 있다.
*/

/*입력
3 3
0 0 0
0 0 0
0 0 0
*/

/*출력
1
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        long[][] A = new long[N][M];
        long ans = 0L;
        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        for (int i = 0; i < N; i++ ) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                A[i][j] = Long.parseLong(st.nextToken());
            }
        }
        for (int i = 1; i < N-1; i ++) {
            for (int j = 1; j < M-1; j ++) {
                long minHeight = Long.MAX_VALUE;
                for (int[] direction : directions) {
                    int ni = i+direction[0], nj = j+direction[1];
                    if (A[i][j] >= A[ni][nj]) {
                        minHeight = Math.min(minHeight, A[ni][nj]);
                    }
                }
                if (minHeight < A[i][j]) {
                    ans += minHeight;
                } else {
                    if (A[i][j] > 0) {
                        ans += A[i][j]-1L;
                    }
                }
            }
        }
        bw.write(ans == Long.MAX_VALUE ? "0" :String.valueOf(ans));
        bw.close();
        br.close();
    }




}

/*
 * */
