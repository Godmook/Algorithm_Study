package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_2805 {
    static int[]array;
    static int[]s;
    static long BSearch(int max){
        long start=0;
        long end=max;
        long mid;
        while(start<=end){
            mid=(start+end)/2;
            long sum=0;
            for(int e:array){
                if(e>mid)sum+=e-mid;
            }
            if(sum>=s[1])start=mid+1;
            else end=mid-1;
        }
        return end;
    }
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st=new StringTokenizer(br.readLine());
        array=new int[s[0]];
        for(int i=0;i<s[0];i++){
            array[i]=Integer.parseInt(st.nextToken());
        }
        int max=Arrays.stream(array).max().getAsInt();
        bw.write(Long.toString(BSearch(max)));
        bw.flush();
    }
}
