package Baekjoon;

import java.io.*;
import java.util.*;

public class P_11651 {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a= Integer.parseInt(br.readLine());
        int [][]array = new int [a][2];
        for(int i=0;i<a;i++){
            array[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        Arrays.sort(array, (o1,o2)-> {
            if(o1[1]==o2[1]) {
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        });
        for(int i=0;i<a;i++){
            bw.write(array[i][0]+" "+array[i][1]+"\n");
        }
        bw.flush();
    }
}
