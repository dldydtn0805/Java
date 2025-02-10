// https://www.acmicpc.net/problem/1261

/*해설
간단한 다익스트라 문제이다.
*/

/*입력
3 3
011
111
110
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken());
        int [][] maze = new int[N][M];

        for (int i = 0; i < N; i ++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line[j]);
            }
        }
        bw.write(String.valueOf(dijkstra(N, M, maze)));
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra (int N, int M, int[][] maze) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] distance = new int[N][M];
        int [][] directions = {{-1,0},{0,1},{1,0},{0,-1}};
        int INF = Integer.MAX_VALUE;
        for (int[] row : distance) Arrays.fill(row, INF);
        int[] start = {0, 0, 0};
        heap.add(start);
        distance[0][0] = 0;
        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int cw = cur[0], ci = cur[1], cj = cur[2];
            if (cw > distance[ci][cj]) {
                continue;
            }
            for (int[] direction : directions) {
                int ni = ci+direction[0], nj = cj+direction[1];
                if (0 <= ni && ni < N && 0 <= nj && nj < M) {
                    int nw = cw + maze[ni][nj];
                    if (nw < distance[ni][nj]) {
                        int[] next = {nw, ni, nj};
                        distance[ni][nj] = nw;
                        heap.add(next);
                    }
                }
            }
        }
        return distance[N-1][M-1];
    }
}

/*
 * */
