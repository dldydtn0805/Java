// https://www.acmicpc.net/problem/2567

/*해설
검은 색종이의 테두리를 구하기 위해, 그래프 탐색을 사용할 수 있는지 묻는 문제이다.
*/

/*입력
4
3 7
5 2
15 7
13 14
 */

/*출력
96
 */

import java.io.*;
import java.util.*;

public class Main {
    static int M = 102;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] drawingPaper = new int[M][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int j = x; j < x+10; j++) {
                for (int k = y; k < y+10; k++) {
                    drawingPaper[j][k] = 1;
                }
            }
        }

        boolean[][] visited = new boolean[M][M];
        int ans = 0;
        for (int i = 0 ; i < M ; i++) {
            for (int j = 0; j < M; j++) {
               ans += bfs(i, j, visited, drawingPaper);
            }
        }
        bw.write(String.valueOf(ans));
        bw.close();
        br.close();
    }
    public static int bfs (int si, int sj, boolean[][] visited, int[][] drawingPaper) {
        if (visited[si][sj] || drawingPaper[si][sj] == 1) return 0;

        int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(si, sj));
        visited[si][sj] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            Node cur = queue.pollFirst();
            int ci = cur.x, cj = cur.y;
            for (int[] direction : directions) {
                int ni = ci+direction[0], nj = cj+direction[1];
                if (0 <= ni && ni < M && 0<= nj && nj < M && !visited[ni][nj]) {
                    if (drawingPaper[ni][nj] == 0) {
                        queue.add(new Node(ni, nj));
                        visited[ni][nj] = true;
                    } else if (drawingPaper[ni][nj] == 1) {
                        cnt ++;
                    }
                }
            }
        }
        return cnt;
    }

    public static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

/*
 * */
