package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11441 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        int []array= new int [a+1];
        for(int i=1;i<a+1;i++){
            int e=Integer.parseInt(st.nextToken());
            array[i]=array[i-1]+e;
        }
        int b=Integer.parseInt(br.readLine());
        for(int i=0;i<b;i++){
            int []tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(array[tmp[1]]-array[tmp[0]-1]+"\n");
        }
        bw.flush();
    }
}
