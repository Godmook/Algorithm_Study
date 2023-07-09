package Baekjoon;

import java.io.*;

public class P_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String key_str="";
        String a=br.readLine();
        String b=br.readLine();
        String main_str=br.readLine();
        int ans=0;
        int maxim= (int) Math.floor(Integer.parseInt(b));
        while(true){
            key_str="";
            for(int i=0;i<maxim;i++){
                key_str+="IO";
            }
            key_str+="I";
            if(main_str.contains(key_str))break;
            else maxim--;
        }
        System.out.println(maxim);
        ans=maxim+1-Integer.parseInt(a);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
