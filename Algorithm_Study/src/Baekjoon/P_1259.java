package Baekjoon;

import java.io.*;

public class P_1259 {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        while(true){
            String tmp=br.readLine();
            if(tmp.equals("0"))break;
            StringBuffer bf =new StringBuffer(tmp);
            if(tmp.startsWith(bf.reverse().toString()))bw.write("yes\n");
            else bw.write("no\n");
        }
        bw.flush();
    }
}
