package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        String []array=new String[a];
        for(int i=0;i<a;i++)array[i]=br.readLine();
        array=Arrays.stream(array).distinct().toArray(String[]::new);
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length()==o2.length())return o1.compareTo(o2);
                else{
                    return o1.length()-o2.length();
                }
            }
        });
        for(int i=0;i<array.length;i++)bw.write(array[i]+"\n");
        bw.flush();
    }
}
