package Baekjoon;

import java.io.*;

public class P_1032 {
    static int[] array;
    public static void main(String args[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        String origin="";
        String tmp="";
        for(int i=0;i<a;i++){
            if(i==0) {
                origin = br.readLine();
                array=new int[origin.length()];
            }
            else
                tmp=br.readLine();
            if(i!=0){
                for(int j=0;j<origin.length();j++){
                    if(origin.charAt(j)!=tmp.charAt(j)){
                        array[j]=1;
                    }
                }
            }
        }
        for(int i=0;i<origin.length();i++){
            if(array[i]==0)
                bw.write(origin.charAt(i));
            else
                bw.write("?");
        }
        bw.flush();
    }
}
