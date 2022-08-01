package Baekjoon;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class P_1251 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String fin="";
        String origin = br.readLine();
        int flag=0;
        for(int i=0;i<origin.length()-2;i++){
            for(int j=i+1;j<origin.length()-1;j++){
                flag++;
                    String A = origin.substring(0, i+1);
                    String B = origin.substring(i+1,j+1);
                    String C = origin.substring(j+1,origin.length());
                    StringBuffer sa=new StringBuffer(A);
                    String reverseA=sa.reverse().toString();
                    StringBuffer sb=new StringBuffer(B);
                    String reverseB=sb.reverse().toString();
                    StringBuffer sc=new StringBuffer(C);
                    String reverseC=sc.reverse().toString();
                    String res=reverseA+reverseB+reverseC;
                if(flag==1){
                    fin=res;
                }
                    if(fin.compareTo(res)>0)fin=res;
            }
        }
        bw.write(fin);
        bw.flush();
    }
}
