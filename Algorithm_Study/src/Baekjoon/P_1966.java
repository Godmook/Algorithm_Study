package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_1966 {
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int size=Integer.parseInt(st.nextToken());
            int idx=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            queue=new LinkedList<>();
            int tmp=-1;
            for(int j=0;j<size;j++){
                int e=Integer.parseInt(st.nextToken());
                if(j==idx)tmp=e;
                queue.offer(e);
            }
            for(int j=0;j<size;j++) {
                queue.stream().max(Integer::compareTo).get();
            }
        }
    }
}
