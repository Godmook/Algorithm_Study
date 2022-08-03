package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11050 {
    static int Factorial(int a){
        if(a<=1)return 1;
        return Factorial(a-1)*a;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        bw.write(Integer.toString(Factorial(a)/(Factorial(b)*Factorial(a-b))));
        bw.flush();

    }
}
