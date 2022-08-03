package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_18111 {
    public static void main(String [] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int []s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][]array=new int [s[0]][s[1]];
        for(int i=0;i<s[0];i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j=0;j<s[1];j++){
                array[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        long min=Long.MAX_VALUE;
        int height=0;
        for(int i=0;i<=256;i++){
            int get=0;
            int remove=0;
            for(int j=0;j<s[0];j++){
                for(int k=0;k<s[1];k++){
                    int e=array[j][k]-i;
                    if(e<0)get+=Math.abs(e);
                    else remove+=Math.abs(e);
                }
            }
            if(remove+s[2]>=get){
                long time=remove* 2L +get;
                if(min>=time){
                    min=time;
                    height=i;
                }
            }
        }
        bw.write(min+" "+height);
        bw.flush();
    }
}
