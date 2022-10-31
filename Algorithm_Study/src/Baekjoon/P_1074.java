package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1074 {
    static int count=0;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int []s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int size=(int) Math.pow(2,s[0]);
        find(size,s[1],s[2]);
        bw.write(Integer.toString(count));
        bw.flush();
    }
    static void find(int size, int c, int r){
        if(size==1)return;
        int half=size/2;
        if(c/half==0 && r/half==0){
            find(size/2,c%half,r%half);
        }
        else if(c/half==0 && r/half==1){
            count+=half*half*1;
            find(size/2,c%half,r%half);
        }
        else if(c/half==1 && r/half==0){
            count+=half*half*2;
            find(size/2,c%half,r%half);
        }
        else{
            count+=half*half*3;
            find(size/2,c%half,r%half);
        }
    }
}
