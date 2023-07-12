package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1149 {
    private static void DP(int max){
        for(int i=1;i<=max;i++){
            dp[i][0]=Math.min(dp[i-1][1],dp[i-1][2])+map[i][0];
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][2])+map[i][1];
            dp[i][2]=Math.min(dp[i-1][1],dp[i-1][0])+map[i][2];
        }
    }
    static int dp[][];
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a = br.readLine();
        dp=new int [Integer.parseInt(a)+1][3];
        map=new int [Integer.parseInt(a)+1][3];
        for(int i=0;i<Integer.parseInt(a);i++){
           map[i+1]= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        DP(Integer.parseInt(a));
        bw.write(Integer.toString(Math.min(Math.min(dp[Integer.parseInt(a)][0],dp[Integer.parseInt(a)][1]),dp[Integer.parseInt(a)][2])));
        bw.flush();
    }
}
