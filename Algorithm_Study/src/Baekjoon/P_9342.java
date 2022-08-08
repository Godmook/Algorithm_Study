package Baekjoon;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        String regex="^[A-F]?A+F+C+[A-F]?$";  //regular regex
        Pattern p=Pattern.compile(regex);
        int a= Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            String tmp=br.readLine();
            Matcher m= p.matcher(tmp);
            if(m.matches())bw.write("Infected!\n");
            else bw.write("Good\n");
        }
        bw.flush();
    }
}
