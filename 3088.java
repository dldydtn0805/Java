// https://www.acmicpc.net/problem/3088

/*해설

상근이가 화분 N개를 놓았고 태완이는 화분을 모두 부수고자 한다.

화분은 한줄로 놓여져있고, 세 정수가 쓰여있다.

태완이가 화분 하나를 깼을때,

화분에 쓰여져 있는 숫자와 오른쪽에 있는 임의의 화분의 숫자가 하나라도 겹치면, 해당하는 화분은 깨진다.

이는 연쇄적이다.

태완이는 화분 하나만 깨서 모든 화분을 깰수있다

태완이는 되도록 적은 수의 화분을 직접깰것이다.

태완이가 직접깨야하는 화분 개수의 최솟값은 ?

아주 간단한 해시 문제이다.

기존 해시 집합에 현재 깨야할 화분에 적힌 숫자가 포함되어있다면, 이미 깨진 상태이므로 개수를 세지않는다.
*/

/*입력
3
1 2 3
2 3 4
4 5 6
*/

/*출력
1
*/

import java.io.*;
import java.util.*;

public class Main {
    static Integer INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        HashSet<Integer> check = new HashSet<>();
        int cnt = 0;
        for (int i = 0 ; i < N ; i ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            if (!(check.contains(A) || check.contains(B) || check.contains(C))) {
                cnt ++;
            }
            check.add(A);
            check.add(B);
            check.add(C);
        }
        bw.write(String.valueOf(cnt));
        bw.close();
        br.close();
    }

}

/*
 * */
