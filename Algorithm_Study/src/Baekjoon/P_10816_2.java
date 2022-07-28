package Baekjoon;

import java.io.*;
import java.util.*;

public class P_10816_2 {
    static final LinkedHashMap hashmap=new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        int tmp=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<tmp;i++){
            int e=Integer.parseInt(st.nextToken());
            if(hashmap.containsKey(e)){
                hashmap.put(e,(Integer)hashmap.get(e)+1);
            }
            else{
                hashmap.put(e,1);
            }
        }
        int b=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<b;i++){
            int e=Integer.parseInt(st.nextToken());
            if(hashmap.containsKey(e))
                sb.append(hashmap.get(e)+" ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}
