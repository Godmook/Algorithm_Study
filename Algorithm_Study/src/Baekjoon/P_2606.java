package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_2606 {
    private static void dfs(int x){
        visited[x]=true;
        for(int i=1;i<Integer.parseInt(a)+1;i++){
            if(map[x][i]==1 && !visited[i]){
                ans++;
                dfs(i);
            }
        }
    }
    static int ans;
    static int map[][];
    static String a;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        a = br.readLine();
        String b= br.readLine();
        map = new int [Integer.parseInt(a)+1][Integer.parseInt(a)+1];
        visited=new boolean[Integer.parseInt(a)+1];
        ans=0;
        for(int i=0;i<Integer.parseInt(b);i++){
            int []s=new int[2];
            s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[s[0]][s[1]]=map[s[1]][s[0]]=1;
        }
        dfs(1);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
