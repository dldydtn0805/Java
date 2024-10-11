import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 0 ;
        final double PI = 3.1415927;
        final int M = 5280 * 12;
        final int H = 60 * 60;

        while (true) {
            tc++;
            String[] input = br.readLine().split(" ");
            double A = Double.parseDouble(input[0]);
            double B = Double.parseDouble(input[1]);
            double C = Double.parseDouble(input[2]);

            if (B == 0) {
                break;
            }

            double distance = PI * A * B / M;
            double time = PI * A * B / M / C * H;

            System.out.printf("Trip #%d: %.2f %.2f%n", tc, distance, time);
        }
        br.close();
    }
}
