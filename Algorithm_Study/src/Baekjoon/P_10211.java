package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P_10211 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            int b=Integer.parseInt(br.readLine());
            StringTokenizer st= null;
            int []array=new int[b];
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){
                array[j]=Integer.parseInt(st.nextToken());
            }
            int []dp=new int[b];
            dp[0]=array[0];
            int max=array[0];
            for(int k=1;k<b;k++){
                if(dp[k-1]<0)dp[k-1]=0;
                dp[k]=array[k]+dp[k-1];
                max=Math.max(dp[k],max);
            }
            bw.write(max+"\n");
            bw.flush();
        }
    }
}
