package Baekjoon;

import java.io.*;

public class P_1543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line=br.readLine();
        String compare=br.readLine();
        int ans=0;

        while(line.length()>0){
            if(line.startsWith(compare)){
                line=line.substring(compare.length());
                ans++;
            }
            else{
                line=line.substring(1);
            }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
