package Baekjoon;

import java.io.*;
import java.util.*;

public class P_7568 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        int [][]compare=new int[a][2];
        LinkedList<Integer> list=new LinkedList<>();
        for(int i=0;i<a;i++){
            compare[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for(int i=0;i<a;i++){
            int res=1;
            for(int j=0;j<a;j++){
                if(i==j)continue;

                if (compare[i][0] < compare[j][0] && compare[i][1]< compare[j][1])
                        res++;
            }
            list.add(res);
        }
        for(Integer res:list){
            bw.write(res+" ");
            bw.flush();
        }
    }
}
