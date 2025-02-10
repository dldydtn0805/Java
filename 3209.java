// https://www.acmicpc.net/problem/3209

/*해설
현재시간과 정인이가 나트륨을 던질 시간이 주어질때, 정인이가 얼마나 숨어있어야 하는가?
 */

/*입력
20:00:00
04:00:00
 */

/*출력
08:00:00
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] currentTime  = br.readLine().split(":");
        String[] targetTime = br.readLine().split(":");

        int[] spendingTime = {
                Integer.parseInt(targetTime[0])-Integer.parseInt(currentTime[0]),
                Integer.parseInt(targetTime[1])-Integer.parseInt(currentTime[1]),
                Integer.parseInt(targetTime[2])-Integer.parseInt(currentTime[2]),
        };

        for (int i = 2; i > 0; i--) {
            if (spendingTime[i] < 0) {
                spendingTime[i-1]--;
                spendingTime[i]+=60;
            }
        }
        if (spendingTime[0] < 0) {
            spendingTime[0]+=24;
        }
        if (spendingTime[0] == 0 && spendingTime[1] == 0 && spendingTime[2] == 0) {
            bw.write("24:00:00");
        } else {
            for (int i = 0; i < 2; i++) {
                bw.write(String.format("%s:", spendingTime[i] >= 10 ? String.valueOf(spendingTime[i]) : "0"+String.valueOf(spendingTime[i])));
            }
            bw.write(String.format("%s", spendingTime[2] >= 10 ? String.valueOf(spendingTime[2]) : "0"+String.valueOf(spendingTime[2])));
        }
        bw.flush();
        bw.close();
    }
}
