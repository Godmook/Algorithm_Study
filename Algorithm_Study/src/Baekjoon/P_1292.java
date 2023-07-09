package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class P_1292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] res=new int[1002];
        int [] stop =new int[101];
        for(int i=1;i<101;i++){
            stop[i]=i;
            if(i!=1){
                stop[i]+=stop[i-1];
            }
        }
        for(int i=1;i<1001;i++){
            int idx=0;
            for(int j=1;j<101;j++){
                if(i<=stop[j] && i>stop[j-1]){
                    idx=j;
                    break;
                }
            }
            res[i]=idx;
            if(i!=1)res[i]+=res[i-1];
        }
        StringTokenizer st= new StringTokenizer(br.readLine());
        int start=res[Integer.parseInt(st.nextToken())-1];
        int end=res[Integer.parseInt(st.nextToken())];
        bw.write(Integer.toString(end-start));
        bw.flush();
    }
}
