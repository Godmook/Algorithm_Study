package Baekjoon;

import java.io.*;
import java.security.Key;
import java.util.*;

class KeySet_12851 {
    private int current;
    private int time;
    KeySet_12851(int current,int time){
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
public class P_12851 {
    private static void bfs(int start_num){
        queue.add(new KeySet_12851(start_num,0));
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                KeySet_12851 tmp=queue.poll();
                visited[tmp.getCurrent()]=true;
                if(tmp.getCurrent()==s[1]){
                    ans=Math.min(ans,tmp.getTime());
                    map.put(tmp.getTime(), map.getOrDefault(tmp.getTime(),0)+1);
                }
                if(tmp.getCurrent()*2<=100000 && !visited[tmp.getCurrent()*2])queue.add(new KeySet_12851(tmp.getCurrent()*2,tmp.getTime()+1));
                if(tmp.getCurrent()-1>=0)
                    if(!visited[tmp.getCurrent()-1])queue.add(new KeySet_12851(tmp.getCurrent()-1,tmp.getTime()+1));
                if(tmp.getCurrent()+1<=100000&& !visited[tmp.getCurrent()+1])queue.add(new KeySet_12851(tmp.getCurrent()+1,tmp.getTime()+1));
            }
        }
    }
    static Queue<KeySet_12851> queue;
    static int s[];
    static int ans;
    static boolean visited[];
    static Map<Integer,Integer> map;
    public static void main(String[] args) throws IOException {
        Comparator<Integer> comparator = (s1,s2) -> s1-s2;
        map=new TreeMap<>(comparator);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        queue=new LinkedList<>();
        ans=Integer.MAX_VALUE;
        visited=new boolean[100001];
        bfs(s[0]);
        bw.write(Integer.toString(ans)+"\n"+Integer.toString(map.get(ans)));
        bw.flush();
    }
}
