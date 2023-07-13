package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1987 {
    private static void dfs(int row, int col,int repeat){
        visited[map[row][col]-'A']=true;
        ans=Math.max(ans,repeat);
        for(int i=0;i<dx.length;i++){
            int nx=row+dx[i];
            int ny=col+dy[i];
            if(nx>=s[0] || nx<0 || ny>=s[1]||ny<0)continue;
            if(visited[map[nx][ny]-'A'])continue;
            dfs(nx,ny,repeat+1);
            visited[map[nx][ny]-'A']=false;
        }
    }
    static int ans;
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static int []s;
    static char[][]map;
    static boolean []visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map=new char[s[0]][s[1]];
        visited=new boolean[27];
        for(int i=0;i<s[0];i++){
            map[i]=br.readLine().toCharArray();
        }
        ans=Integer.MIN_VALUE;
        dfs(0,0,1);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
