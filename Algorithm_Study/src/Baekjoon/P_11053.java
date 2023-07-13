package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_11053 {
    static int []arr;
    static int []dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        arr=new int [a];
        arr= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dp=new int[a];
        int ans=0;
        for(int i=0;i<a;i++){
            dp[i]=1;
            for(int j=i-1;j>=0;j--){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
