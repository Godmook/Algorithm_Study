package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;


public class P_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        String [][]array=new String[a][2];
        for(int i=0;i<a;i++){
            array[i]=br.readLine().split(" ");
        }

        Arrays.sort(array, Comparator.comparingInt(o -> Integer.parseInt(o[0])));
        for(int i=0;i<a;i++){
            bw.write(array[i][0]+" "+array[i][1]+"\n");
        }
        bw.flush();
    }
}
