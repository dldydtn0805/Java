import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N ; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int value = X;
        boolean flag = true;
        int ans = 0;
        while (flag) {
            for (int i = 0; i < N ; i++) {
                if (arr[i] < value) {
                    ans = i+1;
                    flag = false;
                    break;
                } else {
                    value += 1;
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
