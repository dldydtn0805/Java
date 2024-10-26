import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int availablePlugs = 1;

        for (int i = 0; i < N; i++) {
            int plugs = Integer.parseInt(br.readLine());

            availablePlugs += (plugs - 1);
        }

        System.out.println(availablePlugs);

        br.close();
    }
}
