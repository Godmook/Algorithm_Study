package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair_7576 {
    private int x;
    private int y;
    Pair_7576(int x,int y){
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class P_7576 {
    static void dfs(Queue<Pair_7576> array){
        while(!queue.isEmpty()) {
            Pair_7576 tmp=queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.getX() + dx[i];
                int ny = tmp.getY() + dy[i];
                if (nx >= s[1] || nx < 0 || ny >= s[0] || ny < 0) continue;
                if (map[nx][ny] == -1) continue;
                if (map[nx][ny] == 0) {
                    map[nx][ny] = map[tmp.getX()][tmp.getY()]+1;
                    if(ans<map[nx][ny])ans=map[nx][ny];
                    total_sum++;
                    array.add(new Pair_7576(nx, ny));
                }
            }
        }
    }
    static int ans;
    final static int []dx={1,0,-1,0};
    final static int []dy={0,1,0,-1};
    static int [][]map;
    static boolean [][]visited;
    static int []s;
    static int total_sum;
    static int total_cnt;
    static Queue<Pair_7576> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        s=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        map=new int[s[1]][s[0]];
        ans=0;
        queue=new LinkedList<>();
        total_sum=0;
        total_cnt=s[0]*s[1];
        int zero_cnt=0;
        for(int i=0;i<s[1];i++){
            map[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j=0;j<s[0];j++){
                if(map[i][j]==1){
                    total_sum++;
                    queue.add(new Pair_7576(i,j));
                }
                if(map[i][j]==-1)total_cnt--;
                if(map[i][j]==0)zero_cnt++;
            }
        }
        if(zero_cnt==total_cnt)ans=0;
        else {
            dfs(queue);
            if (total_sum != total_cnt) ans = -1;
            else ans -= 1;
        }
            bw.write(Integer.toString(ans));
        bw.flush();
    }
}
