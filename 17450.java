import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double ans = 0;
        int ans_idx = 0;
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int price = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            double cur;
            if (10*price >= 5000) {
                cur = (double) (10*weight) / ((10*price)-500);
            } else {
                cur = (double) (10*weight) / (10*price);
            }
            if (ans < cur) {
                ans_idx = i;
                ans = cur;
            }
        }
        String[] result = {"S", "N", "U"};
        System.out.println(result[ans_idx]);
        br.close();
    }
}
