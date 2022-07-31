package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int []k= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st=null;
        int []array=new int[k[0]];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<k[0];i++){
            int e=Integer.parseInt(st.nextToken());
            if(i!=0){
                array[i]=array[i-1]+e;
            }
            else{
                array[i]=e;
            }
        }
        for(int i=0;i<k[1];i++){
            int []tmp= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            tmp[0]-=2;
            tmp[1]-=1;
            if(tmp[0]>-1)
                bw.write(array[tmp[1]]-array[tmp[0]]+"\n");
            else
                bw.write(array[tmp[1]]+"\n");
            bw.flush();
        }
    }
}
