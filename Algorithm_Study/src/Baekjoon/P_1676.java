package Baekjoon;

import java.io.*;
import java.util.*;
public class P_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String num=br.readLine();
        int ans=0;
        int count_2=0;
        int count_5=0;
        for(int i=2;i<=Integer.parseInt(num);i++){
            int tmp=i;
            while(tmp%2==0 || tmp%5==0){
                if(tmp%2==0) {
                    count_2++;
                    tmp /= 2;
                }
                if(tmp%5==0){
                    count_5++;
                    tmp/=5;
                }
            }
        }
        bw.write(Integer.toString(Math.min(count_2,count_5)));
        bw.flush();
    }
}
