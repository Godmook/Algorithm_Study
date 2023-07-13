package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_10830 {
    private static int [][] multiply(int [][]o1, int[][]o2){
        int [][]res= new int[(int)s[0]][(int)s[0]];
        for(int i=0;i<s[0];i++){
            for(int j=0;j<s[0];j++){
                for(int m=0;m<s[0];m++){
                    res[i][j]+=o1[i][m]*o2[m][j];
                    res[i][j]%=1000;
                }
            }
        }
        return res;
    }
    private static int [][] solution(int [][] A,long exp){
        if(exp==1L){
            return A;
        }
        int [][] res= solution(A,exp/2);
        res=multiply(res,res);
        if(exp%2==1L){
            res=multiply(res,mat);
        }

        return res;
    }
    static long s[];
    static int mat[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        mat=new int[(int)s[0]][(int)s[0]];
        for(int i=0;i<(int)s[0];i++){
            mat[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<(int)s[0];j++){
                mat[i][j]%=1000;
            }
        }
        int [][]ans;
        ans=solution(mat,s[1]);
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<s[0];i++){
            for(int j=0;j<s[0];j++){
                builder.append(ans[i][j]).append(' ');
            }
            builder.append("\n");
        }
        bw.write(builder.toString());
        bw.flush();
    }
}
