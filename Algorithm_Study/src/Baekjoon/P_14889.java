package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_14889 {
    static int a;
    static int [][] array;
    static boolean [] visited;

    static int min=Integer.MAX_VALUE;
    static void comb(int idx,int count){
        if(count==a/2){
            ans();
            return;
        }
        for(int i=idx;i<a;i++){
            if(!visited[i]){
                visited[i]=true;
                comb(i+1,count+1);
                visited[i]=false;
            }
        }
    }
    static void ans(){
        int res1=0;
        int res2=0;
        for(int i=0;i<a-1;i++){
            for(int j=i;j<a;j++){
                if(visited[i]==true && visited[j]==true){
                    res1+=array[i][j];
                    res1+=array[j][i];
                }
                if(visited[i]==false && visited[j]==false){
                    res2+=array[i][j];
                    res2+=array[j][i];
                }
            }
        }
        int diff=Math.abs(res1-res2);
        min=Math.min(diff,min);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a=Integer.parseInt(br.readLine());
        array=new int[a][a];
        visited=new boolean[a];
        for(int i=0;i<a;i++){
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<a;j++){
                array[i][j]=s[j];
            }
        }
        comb(0,0);
        bw.write(Integer.toString(min));
        bw.flush();
    }
}
