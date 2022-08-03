package Baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P_10866 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<a;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            String order=st.nextToken();
            if(order.equals("push_back")){
                deque.offerLast(Integer.parseInt(st.nextToken()));
            }
            if(order.equals("push_front")){
                deque.offerFirst(Integer.parseInt(st.nextToken()));
            }
            if(order.equals("pop_front")){
                Object v=deque.pollFirst();
                if(v==null)bw.write("-1\n");
                else bw.write(v+"\n");
            }
            if(order.equals("pop_back")){
                Object v= deque.pollLast();
                if(v==null)bw.write("-1\n");
                else bw.write(v+"\n");
            }
            if(order.equals("size"))bw.write(deque.size()+"\n");
            if(order.equals("empty")){
                if(deque.isEmpty())bw.write("1\n");
                else bw.write("0\n");
            }
            if(order.equals("front")){
                if(deque.isEmpty()){
                    bw.write("-1\n");
                }
                else bw.write(deque.peekFirst()+"\n");
            }
            if(order.equals("back")){
                if(deque.isEmpty()){
                    bw.write("-1\n");
                }
                else bw.write(deque.peekLast()+"\n");
            }
            bw.flush();
        }
    }
}
