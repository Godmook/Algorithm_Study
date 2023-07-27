package Baekjoon;

import java.io.*;

public class P_27866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int a = Integer.parseInt(br.readLine());
        bw.write(s.charAt(a-1));
        bw.flush();
    }
}
