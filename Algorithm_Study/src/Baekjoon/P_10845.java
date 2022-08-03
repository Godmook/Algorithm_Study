package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P_10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        Queue<Integer> queue=new LinkedList<>();
        int tmp=-1;
        for(int i=0;i<a;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String order=st.nextToken();
            if(order.equals("push")){
                int e=Integer.parseInt(st.nextToken());
                queue.offer(e);
                tmp=e;
            }
            if(order.equals("pop")){
                if(queue.size()==1)tmp=-1;
                Object v=queue.poll();
                if(v==null)bw.write("-1\n");
                else bw.write( v+"\n");
            }
            if(order.equals("size")){
                bw.write(queue.size()+"\n");
            }
            if(order.equals("empty")){
                if(queue.isEmpty())bw.write("1\n");
                else bw.write("0\n");
            }
            if(order.equals("front")){
                Object v=queue.peek();
                if(v==null)bw.write("-1\n");
                else bw.write(v+"\n");
            }
            if(order.equals("back")){
                bw.write(tmp+"\n");
            }
        }
        bw.flush();
    }
}
