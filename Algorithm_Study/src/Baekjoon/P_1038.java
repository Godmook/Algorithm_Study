package Baekjoon;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class P_1038 {
    static Deque<Long> deque;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        int cnt=-1;
       if(a>1022)bw.write("-1");
       else{
            deque=new ArrayDeque<>();
            for(int i=0;i<10;i++)deque.offer((long) i);
            while(!deque.isEmpty()){
                long num=deque.pollFirst();
                cnt++;
                if(cnt==a){
                    bw.write(Long.toString(num));
                    break;
                }
                for(int i=0;i<num%10;i++){
                    deque.offer((num*10)+i);
                }
            }
        }
        bw.flush();
    }
}
