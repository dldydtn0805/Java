// https://www.acmicpc.net/problem/31797

/*해설

1. 게임을 시작한 사람이 아파트 층 수를 정한다.

2. 모든 참가자는 자신의 두 손을 다른 사람과 겹치지 않는 높이로 뻗어 모든 참가자의 두 손이 서로 쌓이게 한다

3. 가장 아래에 있는 손을 빼 쌓어있는 손 가장 위에 쌓는다.

4. 3의 과정을 N번 반복한다. j 번째로 쌓은 손이 j 층이 된다

5. N 층을 쌓는 참가자가 술을 마신다.

술을 마시게 될 사람의 번호를 구하라

아파트 층 수 N, 참자가 수 M이 주어진다.

각 참가자의 두 손의 높이가 공백으로 주어진다. 모든 두 손은 같은 높이가 아니다

이는 우선순위 큐로 간단히 구할수 있다.
순차적으로 모든 참가자들의 양손 높이가 주어진다. 이 높이들을 우선순위 큐에 참가자 번호와 함께 넣는다.

손을 탑으로 쌓은 후, 게임은 시작된다.

가장 낮은 위치의 손이 가장 높은 손 바로 위로 올라간다.

이를 위해 우리는 우선순위 큐에 넣을 때, 가장 높은 손의 높이를 갱신하며 넣어주어야한다.

그저 게임을 진행하며 우선순위 큐의 가장 낮은 손을 꺼내 가장 높은 위치로 옮기면 되는 문제가 된 것이다.

그리고 N번째 차례가 되었을 때의 참가자 번호를 출력하면 되는 것이다.

이 문제를 통해 새롭게 알게된 것은, 자바는 우선순위 큐를 선언할때 Comparator [정렬 기준]을 설정하여

특정 키 값을 기준으로 자동 정렬이 가능하다는 것이다.

*/

/*입력
5 3
1 6
3 4
2 5
*/

/*출력
3
*/

import java.io.*;
import java.util.*;

public class Main {
    static Integer INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> minHq = new PriorityQueue<>((a, b)->a[0]-b[0]);
        int maxHeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int[] cur1 = new int[2];
            cur1[0] = h1;
            cur1[1] = i+1;
            maxHeight = Math.max(maxHeight, h1+1);
            minHq.add(cur1);

            int h2 = Integer.parseInt(st.nextToken());
            int[] cur2 = new int[2];
            cur2[0] = h2;
            cur2[1] = i+1;
            maxHeight = Math.max(maxHeight, h2+1);
            minHq.add(cur2);
        }

        int h = 1;
        while (true) {
            int[] cur = minHq.poll();
            cur[0] = maxHeight++;
            minHq.add(cur);
//            System.out.println(Arrays.toString(cur) + h);
            if (h++ == N) {
                bw.write(String.valueOf(cur[1]));
                break;
            }
        }
        bw.close();
        br.close();
    }


}

/*
 * */
