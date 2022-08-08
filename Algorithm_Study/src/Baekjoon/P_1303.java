package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1303 {
    static void dfs(char ch,int row,int col){
        visited[row][col]=true;
        for(int i=0;i<dx.length;i++){
            int nx=row+dx[i];
            int ny=col+dy[i];
            if(nx>=s[0] || nx<0 || ny>=s[1]||ny<0)continue;
            if(visited[nx][ny])continue;
            if(map[nx][ny]!=ch)continue;
            c++;
            dfs(ch,nx,ny);
        }

    }
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static char [][]map;
    static boolean [][]visited;
    static int []s;
    static int c;
    public static void main(String[] args) throws IOException{
        int ans1=0;
        int ans2=0;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int tmp=s[0];
        s[0]=s[1];
        s[1]=tmp;
        map=new char[s[0]][s[1]];
        visited=new boolean[s[0]][s[1]];
        for(int i=0;i<s[0];i++){
            map[i]=br.readLine().toCharArray();
        }
        for(int i=0;i<s[0];i++){
            for(int j=0;j<s[1];j++){
                if(!visited[i][j]){
                    c=1;
                    dfs(map[i][j],i,j);
                    if(map[i][j]=='B')ans1+=c*c;
                    else ans2+=c*c;
                }
            }
        }
        bw.write(ans2+" "+ans1);
        bw.flush();
    }
}
