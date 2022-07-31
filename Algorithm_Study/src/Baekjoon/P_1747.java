package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_1747 {
    final static int N=1003002;
    final static boolean []cal= new boolean[N+1];
    static void func(){
        for(int i=2;i<=Math.sqrt(N);i++){
            if(cal[i]){
                int j=2;
                while(i*j<=N){
                    cal[i*j]=false;
                    j+=1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        Arrays.fill(cal,Boolean.TRUE);
        cal[1]=false;
        func();
        for(int i=a;;i++){
            if(cal[i]){
                String str=Integer.toString(i);
                String reverse=new StringBuffer(str).reverse().toString();
                if(str.equals(reverse)){
                    bw.write(str);
                    bw.flush();
                    break;
                }
            }
        }
    }
}
