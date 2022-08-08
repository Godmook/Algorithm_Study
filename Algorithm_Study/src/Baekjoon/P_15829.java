package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_15829 {
    static long R=1;
    final static int M=1234567891;
    public static void main(String[] args)throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int s=Integer.parseInt(br.readLine());
        String st=br.readLine();
        long ans=0;
        for(int i=0;i<s;i++){
            ans=(ans+(st.charAt(i)-'a'+1)*R)%M;
            R=(R*31)%M;
        }
        bw.write(ans+"\n");
        bw.flush();
    }
}
