package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class P_1059 {
    static int BinaryPlace(int a){
        int start=0;
        int end=array.size()-1;
        int mid;
        int idx=-1;
        if(a<array.get(0))return 0;
        if(a>=array.get(end))return array.size();
        while(start<=end){
            mid=(start+end)/2;
            if(a<array.get(mid) && a>=array.get(mid-1)){
                idx=mid;
                break;
            }
            else if(a>=array.get(mid))start=mid+1;
            else end=mid-1;
        }
        return idx;
    }
    static List<Integer> array= new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        StringTokenizer st=null;
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
            array.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(array);
        int b=Integer.parseInt(br.readLine());
        int idx=BinaryPlace(b);
        int res=0;
        if(idx>0&&idx<array.size()){
            for(int i=array.get(idx-1)+1;i<array.get(idx);i++){
                for(int j=i+1;j<array.get(idx);j++){
                    if(i<=b && b<=j) {
                        res++;
                    }
                }
            }
        }
        if(idx==0){
            for(int i=1;i<array.get(0);i++){
                for(int j=i+1;j<array.get(0);j++){
                    if(i<=b && b<=j)
                        res++;
                }
            }
        }
        bw.write(Integer.toString(res));
        bw.flush();
    }
}
