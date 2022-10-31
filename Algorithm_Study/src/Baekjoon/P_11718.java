package Baekjoon;

import java.io.*;

public class P_11718 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<100;i++){
            String tmp=br.readLine();
            bw.write(tmp+"\n");
        }
        bw.flush();
    }
}
