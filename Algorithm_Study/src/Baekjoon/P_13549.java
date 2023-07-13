package Baekjoon;

import java.io.*;
import java.security.Key;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class KeySet {
    private int current;
    private int time;
    KeySet(int current,int time){
        this.current=current;
        this.time=time;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
public class P_13549 {
    private static void bfs(int start_num){
        queue.add(new KeySet(start_num,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                KeySet tmp=queue.poll();
                visited[tmp.getCurrent()]=true;
                if(tmp.getCurrent()==s[1]){
                    ans=tmp.getTime();
                    return;
                }
                if(tmp.getCurrent()*2<=100000 && !visited[tmp.getCurrent()*2])queue.add(new KeySet(tmp.getCurrent()*2,tmp.getTime()));
                if(tmp.getCurrent()-1>=0)
                    if(!visited[tmp.getCurrent()-1])queue.add(new KeySet(tmp.getCurrent()-1,tmp.getTime()+1));
                if(tmp.getCurrent()+1<=100000&& !visited[tmp.getCurrent()+1])queue.add(new KeySet(tmp.getCurrent()+1,tmp.getTime()+1));
            }
        }
    }
    static Queue<KeySet> queue;
    static int s[];
    static int ans;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        queue=new LinkedList<>();
        ans=0;
        visited=new boolean[100001];
        bfs(s[0]);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
