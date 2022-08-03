package Baekjoon;

import java.io.*;

public class P_11170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            String []compare = br.readLine().split(" ");
            int res=0;
            for(int j=Integer.parseInt(compare[0]);j<=Integer.parseInt(compare[1]);j++) {
                res+=Integer.toString(j).chars().filter(c -> c == '0').count();
            }
            bw.write(res+"\n");
            bw.flush();
        }
    }
}
