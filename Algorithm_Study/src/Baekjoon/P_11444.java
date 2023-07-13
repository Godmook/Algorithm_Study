package Baekjoon;

import java.io.*;

public class P_11444 {
    private static long [][] multiply(long [][]o1, long[][]o2){
        long [][]res= new long[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                for(int m=0;m<2;m++){
                    res[i][j]+=o1[i][m]*o2[m][j];
                    res[i][j]%=1000000007;
                }
            }
        }
        return res;
    }
    private static long[][] solution(long [][]A, long exp){
        if(exp==1L || exp==0){
            return A;
        }
        long [][]res=solution(A,exp/2);
        res=multiply(res,res);
        if(exp%2==1L){
            res=multiply(res,A);
        }

        return res;
    }
    static long a;
    final static long [][]A = {{1,1},{1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a=Long.parseLong(br.readLine());
        long [][]ans=solution(A,a-1);
        bw.write(Long.toString(ans[0][0]));
        bw.flush();
    }
}
