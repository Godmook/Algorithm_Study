package Baekjoon;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class P_10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int [] s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long [] array =new long[s[0]+1];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1;i<s[0]+1;i++){
            array[i]=array[i-1]+Integer.parseInt(st.nextToken());
        }
        long res=0;
        long []kk=new long[s[1]];
        for(int i=1;i<s[0]+1;i++){
            long sum=array[i]%s[1];
            if(sum==0)res++;
            kk[(int) sum]++;
        }
        for(int i=0;i<s[1];i++){
            if(kk[i]>1){
                res+=(kk[i]*(kk[i]-1)/2);
            }
        }
        bw.write(Long.toString(res));
        bw.flush();
    }
}
