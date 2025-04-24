import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int totalBook = Integer.parseInt(br.readLine());
        for (int i = 0; i < 9; i ++) {
            int book = Integer.parseInt(br.readLine());
            totalBook -= book;
        }
        System.out.println(totalBook);

    }

}
