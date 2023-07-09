package Baekjoon;

import java.io.*;

public class P_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        String b=br.readLine();
        String main_str=br.readLine();
        int ans=0;
        int cnt=0;
        for(int i=0;i<Integer.parseInt(b)-2;i++){
            //System.out.println(main_str.substring(i,i+3));
                if(main_str.substring(i,i+3).equals("IOI")){
                    cnt++;
                    i++;
                    if(cnt==Integer.parseInt(a)){
                        ans++;
                        cnt--;
                    }
                }
                else{
                    cnt=0;
                }
        }
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
