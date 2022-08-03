package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11660 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int []s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int [][]array = new int [s[0]+1][s[0]+1];
        for(int i=0;i<s[0];i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            for(int j=0;j<s[0];j++){
                int e=Integer.parseInt(st.nextToken());
                array[i+1][j+1]=array[i+1][j]+array[i][j+1]-array[i][j]+e;
            }
        }
        for(int i=0;i<s[1];i++){
            int []tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int e=array[tmp[2]][tmp[3]]-array[tmp[0]-1][tmp[3]]-array[tmp[2]][tmp[1]-1]+array[tmp[0]-1][tmp[1]-1];
            bw.write(e+"\n");
        }
        bw.flush();
    }
}
