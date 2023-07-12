package Baekjoon;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_14940 {
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
                if (graph[nx][ny] == 0) continue;
                queue.add(new Point(nx, ny));
                ans[nx][ny] = ans[cur.x][cur.y] + 1;
                visited[nx][ny] = true;
            }
        }
    }
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static int[][]graph;
    static int[][]ans;
    static boolean [][]visited;
    static Queue<Point> queue;
    static int[]s;
    static Point start;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean isCheckStartPoint=false;
        graph=new int[s[0]][s[1]];
        ans=new int[s[0]][s[1]];
        visited=new boolean[s[0]][s[1]];
        for(int i=0;i<s[0];i++){
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if(!isCheckStartPoint){
                for(int j=0;j<s[1];j++){
                    if(graph[i][j]==2){
                        isCheckStartPoint=true;
                        start=new Point(i,j);
                        break;
                    }
                }
            }
        }
        queue=new LinkedList<>();
        bfs(start.x,start.y);
        StringBuilder builder=new StringBuilder();
        for (int i = 0; i < s[0]; i++) {
            for (int j = 0; j < s[1]; j++)
                if (!visited[i][j] && graph[i][j] == 1)
                    builder.append(-1 + " ");
                else
                    builder.append(ans[i][j] + " ");
            builder.append("\n");
        }
        bw.write(builder.toString());
        bw.flush();
    }
}
