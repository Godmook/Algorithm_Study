package Baekjoon;

import java.awt.*;
import java.io.*;
import java.util.*;

public class P_21736 {
    private static void bfs(int x,int y){
        queue.add(new Point(x,y));
        visited[x][y]=true;
        while(!queue.isEmpty()) {
            Point cur=queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= s[0] || nx < 0 || ny >= s[1] || ny < 0) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') {
                    continue;
                }
                if(map[nx][ny]=='P')c++;
                queue.add(new Point(nx, ny));
                visited[nx][ny] = true;

            }
        }
    }
    static Queue <Point> queue;
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static char [][]map;
    static boolean [][]visited;
    static int []s;
    static int c;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map=new char[s[0]][s[1]];
        visited=new boolean[s[0]][s[1]];
        Point start=new Point(0,0);
        boolean checkStartPoint=false;
        for(int i=0;i<s[0];i++){
            map[i]=br.readLine().toCharArray();
            if(!checkStartPoint){
                for(int j=0;j<s[1];j++){
                    System.out.println(map[i][j]);
                    if(map[i][j]=='I'){
                        start=new Point(i,j);
                        checkStartPoint=true;
                    }
                }
            }
        }
        queue=new LinkedList<>();
        c=0;
        bfs(start.x,start.y);
        if(c==0){
            System.out.println("TT");
        }
        else
            System.out.println(c);
    }
}
