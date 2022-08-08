package Baekjoon;

import java.io.*;

public class P_14906 {
    static boolean isSlump(CharSequence input){
        String regex1="^[D,E]F+G$";
        String regex2="^([D,E]F+)\\w+$";
        return true;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        bw.write("SLURPYS OUTPUT\n");
        for(int i=0;i<a;i++){

        }
        bw.write("END OF OUTPUT");
        bw.flush();
    }
}
