package Baekjoon;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P_1013 {
    static boolean matcher(String regex, CharSequence input){
        Pattern p =Pattern.compile(regex);
        Matcher m = p.matcher(input);
        return m.matches();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String regex="(100+1+|01)+";
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            String tmp=br.readLine();
            if(matcher(regex,tmp)){
                bw.write("YES\n");
            }
            else bw.write("NO\n");
        }
        bw.flush();
    }
}
