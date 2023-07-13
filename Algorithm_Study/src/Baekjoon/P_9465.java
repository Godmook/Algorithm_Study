package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_9465 {

    static int [][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<a;i++){
            int b=Integer.parseInt(br.readLine());
            arr=new int[2][b+2];
            for(int j=0;j<2;j++){
                int []tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for(int k=2;k<b+2;k++){
                    arr[j][k]=tmp[k-2];
                }
            }
            for(int j=2;j<b+2;j++){
                arr[0][j]=Math.max(arr[1][j-1],arr[1][j-2])+arr[0][j];
                arr[1][j]=Math.max(arr[0][j-1],arr[0][j-2])+arr[1][j];
            }
            builder.append(Math.max(arr[0][b+1],arr[1][b+1])+"\n");
        }
        bw.write(builder.toString());
        bw.flush();
    }
}
