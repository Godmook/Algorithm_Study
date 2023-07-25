package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1806 {
    static int []arr;
    static int []s;
    public static int[] setSizeIntArray(int[] srcArray, int size) {
        int[] newArray = Arrays.copyOf(srcArray, size);
        return newArray;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start=0;
        int end=0;
        int sum=0;
        int cnt=Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            sum+=arr[i];
        }
        for(int i=0;;i++){
            try{
                if(sum>=s[1]){
                    if(cnt>end-start+1){
                        cnt=end-start+1;
                    }
                    sum-=arr[start++];
                } else if (sum<s[1]){
                    sum+=arr[++end];
                }
            }catch (Exception e){
                break;
            }
        }
        if(cnt==Integer.MAX_VALUE)cnt=0;
        bw.write(Integer.toString(cnt));
        bw.flush();
    }
}
