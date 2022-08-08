package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P_1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        StringTokenizer st= new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<a;i++)
            list.add(Integer.parseInt(st.nextToken()));
        int ans=0;
        Collections.sort(list);
        for(Integer e:list){
            List<Integer> tmp=new ArrayList<>();
            tmp.addAll(list);
            tmp.remove(e);
            int left=0;int right=tmp.size()-1;
            while(left<right){
                int res=tmp.get(left)+tmp.get(right);
                if(e==res){
                    ans++;
                    break;
                }
                if(e<res)right--;
                else left++;
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
