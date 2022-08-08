package Baekjoon;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P_2671 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String regex="(100+1+|01)+";
        String origin=br.readLine();
        Pattern p= Pattern.compile(regex);
        Matcher m = p.matcher(origin);
        if(m.matches())bw.write("SUBMARINE");
        else bw.write("NOISE");
        bw.flush();
    }
}
