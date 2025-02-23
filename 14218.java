// https://www.acmicpc.net/problem/14218

/*해설
q줄에 각 도시별로 수도를 방문하는데 최소 방문 도시들을 출력하시오.

수도를 방문하지 못한다면 -1을 출력하시오.

수도는 0번 도시이다.

단순한 BFS 문제이다.

* 주의할 점은 양방향으로 입력을 받아야한다는것이다.
*/

/*입력
5 3
1 2
1 3
2 4
5
2 3
4 5
3 4
1 4
1 5
* */

/*출력
0 1 1 2 -1
0 1 1 2 3
0 1 1 2 3
0 1 1 1 2
0 1 1 1 1
*/

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[][] adjList = new boolean[N+1][N+1];
        for (int i = 0; i < M; i ++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adjList[A][B] = true;
            adjList[B][A] = true;
        }
        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder("");
        for (int k = 0; k < q; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            adjList[i][j] = true;
            adjList[j][i] = true;
            int[] res = bfs(1, adjList);
            for (int l = 1 ; l < N+1; l++) {
                sb.append(res[l]-1);
                sb.append(l == N ? "" : " ");
            }
            sb.append(k == q-1 ? "" : "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    public static int[] bfs (int si, boolean[][] adjList) {
        LinkedList<Integer> queue = new LinkedList<>();
        int[] visited = new int[N+1];
        queue.add(si);
        visited[si] = 1;

        while (!queue.isEmpty()) {
            int ci = queue.poll();
            for (int ni = 1; ni < N+1; ni++) {
                if (adjList[ci][ni] && visited[ni] == 0) {
                    queue.add(ni);
                    visited[ni] = visited[ci] + 1;
                }
            }
        }
        return visited;
    }

}

/*
0 1 1 2 -1
0 1 1 2 3
0 1 1 2 3
0 1 1 1 2
0 1 1 1 1

0 1 1 2 -1
0 1 1 2 3
0 1 1 2 3
0 1 1 1 2
0 1 1 1 1
*
* */
