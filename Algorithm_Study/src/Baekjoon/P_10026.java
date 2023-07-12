package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_10026 {
    static void dfs(char ch,int row,int col, boolean isDifferent){
        visited[row][col]=true;
        for(int i=0;i<dx.length;i++){
            int nx=row+dx[i];
            int ny=col+dy[i];
            if(nx>=size || nx<0 || ny>=size||ny<0)continue;
            if(visited[nx][ny])continue;
            if(isDifferent) {
                if(map[nx][ny]=='G')map[nx][ny]='R';
                if(ch=='G')ch='R';
            }
            if(map[nx][ny]!=ch)continue;
            dfs(ch,nx,ny,isDifferent);
        }

    }
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static char [][]map;
    static boolean [][]visited;
    static int size;
    static int yesDifferent;
    static int notDifferent;
    public static void main(String[] args) throws IOException{
        yesDifferent=0;
        notDifferent=0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        size=Integer.parseInt(a);
        map=new char[size][size];
        visited=new boolean[size][size];
        for(int i=0;i<size;i++){
            map[i]=br.readLine().toCharArray();
        }
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(!visited[i][j]){
                    notDifferent++;
                    dfs(map[i][j],i,j,false);
                }
            }
        }
        visited=new boolean[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(!visited[i][j]){
                    yesDifferent++;
                    dfs(map[i][j],i,j,true);
                }
            }
        }
        bw.write(Integer.toString(notDifferent)+" "+Integer.toString(yesDifferent));
        bw.flush();
    }
}
