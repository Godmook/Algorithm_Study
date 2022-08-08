package Baekjoon;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P_24343 {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            int []tmp= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int []array=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int flag=1;
            if(Arrays.stream(array).sum()>2*tmp[0])flag=0;
            Arrays.sort(array);
            int bag1=tmp[0];
            int bag2=tmp[0];
            if(flag==1){
                for(int j=0;j<tmp[1];j++){
                    if(array[j]>tmp[0]){
                        flag=0;
                        break;
                    }
                    if(bag1>=bag2){
                        if(bag1<array[j])bag2-=array[j];
                        else bag1-=array[j];
                    }
                    else{
                        if(bag2<array[j])bag1-=array[j];
                        else bag2-=array[j];
                    }
                    if(bag1<0||bag2<0){
                        //bw.write(i+" "+j+" \n");
                        flag=0;break;
                    }
                    //bw.write(bag1+" "+bag2+"\n");
                }
            }
            bw.write(flag+"\n");
        }
        bw.flush();
    }
}
