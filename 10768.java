import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        if (2*30+18 > M*30+D) {
            System.out.println("Before");
        } else if (2*30+18 == M*30+D) {
            System.out.println("Special");
        } else {
            System.out.println("After");

        }
    }
}
