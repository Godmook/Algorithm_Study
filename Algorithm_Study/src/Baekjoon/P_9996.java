package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_9996 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        String []compare = br.readLine().split("\\*");
        int flag=0;
        for(int i=0;i<a;i++){
            flag=0;
            String tmp=br.readLine();
            if(tmp.startsWith(compare[0])){
                flag++;
                if(tmp.length()-compare[1].length()>=0 && tmp.length()-compare[1].length()>=compare[0].length()) {
                    tmp = tmp.substring(tmp.length() - compare[1].length());
                    if (tmp.startsWith(compare[1]))
                        flag++;
                }
            }
            if(flag==2){
                bw.write("DA\n");
                bw.flush();
            }
            else{
                bw.write("NE\n");
                bw.flush();
            }
        }
    }
}
