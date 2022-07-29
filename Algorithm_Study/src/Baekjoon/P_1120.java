package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P_1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line =br.readLine();
        StringTokenizer st=new StringTokenizer(line," ");
        String k1=st.nextToken();
        String k2=st.nextToken();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<k2.length()-k1.length()+1;i++){
            int cnt=0;
            for(int j=0;j<k1.length();j++){
                if(k1.charAt(j)!=k2.charAt(i+j)){
                    cnt++;
                }
            }
            min=Math.min(min,cnt);
        }
        bw.write(Integer.toString(min));
        bw.flush();
    }
}
