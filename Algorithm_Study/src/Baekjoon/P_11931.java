package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        Integer []array=new Integer[a];
        for(int i=0;i<a;i++){
            array[i]=Integer.parseInt(br.readLine());
        }
        Arrays.sort(array, Collections.reverseOrder());
        for(int i=0;i<a;i++){
            bw.write(array[i]+"\n");
        }
        bw.flush();
    }
}
