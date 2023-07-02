package Baekjoon;

import java.io.*;
import java.util.*;
public class P_18110 {
    public static void main(String args[]) throws IOException {
        ArrayList<Integer> arrayList= new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        for(int i=0;i<Integer.parseInt(line);i++){
            String tmp=br.readLine();
            arrayList.add(Integer.parseInt(tmp));
        }
        double cnt=Integer.parseInt(line)*0.15;
        long real_cnt=Math.round(cnt);
        double res=0;
        Collections.sort(arrayList);
        for(int i = (int) real_cnt; i<Integer.parseInt(line)-real_cnt; i++){
            res+=arrayList.get(i);
        }
        res/=(Integer.parseInt(line)-2*real_cnt);
        res=Math.round(res);
        bw.write(Integer.toString((int)res));
        bw.flush();
    }
}
