package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2609 {
    static int GCD(int a,int b){
        if(b==0)return a;
        else{
            return GCD(b,a%b);
        }
    }
    static int LCM(int a,int b){
        return (a*b)/GCD(a,b);
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int []st= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        bw.write(GCD(st[0],st[1])+"\n");
        bw.write(LCM(st[0],st[1])+"\n");
        bw.flush();
    }
}
