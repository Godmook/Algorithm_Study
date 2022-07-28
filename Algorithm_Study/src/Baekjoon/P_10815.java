package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_10815 {
    static int [] cur;
    static int [] find;
    static int binary_search(int []cur,int key){
        int start=0;
        int end=cur.length-1;
        int mid;
        int idx=-1;
        if(key<cur[0])return 0;
        if(key>cur[cur.length-1])return 0;
        while(start<=end){
            mid=(start+end)/2;
            if(key==cur[mid])return 1;
            else if(key<cur[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tmp=Integer.parseInt(br.readLine());
        cur = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int b=Integer.parseInt(br.readLine());
        find = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(cur);
        for(int e:find){
            bw.write(binary_search(cur,e)+" ");
            bw.flush();
        }
    }
}
