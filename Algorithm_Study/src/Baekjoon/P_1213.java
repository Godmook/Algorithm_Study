package Baekjoon;

import com.sun.source.tree.Tree;

import java.io.*;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class P_1213 {
    static Map<Character, Integer> maps;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String k=br.readLine();
        Comparator<Character> comparator =(s1,s2)-> s1.compareTo(s2);
        maps=new TreeMap<>(comparator);
        for(int i=0;i<k.length();i++){
            maps.put(k.charAt(i), maps.getOrDefault(k.charAt(i),0)+1);
        }
        String ans="";
        int odd_cnt=0;
        for(Integer value: maps.values()){
            if(value%2==1)odd_cnt++;
        }
        if(odd_cnt>1){
            bw.write("I'm Sorry Hansoo");
        }
        else{
            if(odd_cnt==0){
                for(Character c: maps.keySet()){
                    Integer cnt=maps.get(c);
                    for(int i=0;i<cnt/2;i++)ans+=c;
                }
                StringBuffer sb= new StringBuffer(ans);
                ans+=sb.reverse().toString();
                bw.write(ans);
            }
            else{
                char ss=0;
                for(Character c: maps.keySet()){
                    Integer cnt=maps.get(c);
                    if(cnt%2==1)ss=c;
                    for(int i=0;i<(int)Math.floor(cnt/2.0);i++)ans+=c;
                }
                StringBuffer sb= new StringBuffer(ans);
                ans+=ss;
                ans+=sb.reverse().toString();
                bw.write(ans);
            }
        }
        bw.flush();
    }
}
