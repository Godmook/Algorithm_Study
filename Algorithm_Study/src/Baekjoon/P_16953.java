package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P_16953 {
    private static void bfs(int start_num){
        queue.add((long)start_num);
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                long tmp=queue.poll();
                if(tmp==s[1]){
                    ans++;
                    return;
                }
                if(tmp*2<=s[1])queue.add(tmp*2);
                if(tmp*10+1<=s[1])queue.add(tmp*10+1);
            }
            ans++;
        }
        ans=-1;
    }
    static Queue<Long> queue;
    static int s[];
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        queue=new LinkedList<>();
        ans=0;
        bfs(s[0]);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
