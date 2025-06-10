import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] ans = new int['z'-'a'+1];
        for (int i = 0; i < line.length(); i ++) {
            ans[line.charAt(i) - 'a'] ++ ;
        }
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < ans.length; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
        br.close();
    }
}
