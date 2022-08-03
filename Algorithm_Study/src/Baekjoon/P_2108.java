package Baekjoon;

import java.io.*;
import java.util.*;

public class P_2108 {
    public static void main(String[] args)throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        double a= Integer.parseInt(br.readLine());
        Integer []array=new Integer[(int)a];
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        double sum=0;
        for(int i=0;i<(int)a;i++){
            int tmp=Integer.parseInt(br.readLine());
            if(min>tmp)min=tmp;
            if(max<tmp)max=tmp;
            sum+=tmp;
            array[i]=tmp;
            if(map.containsKey(tmp)){
                int e=map.get(tmp);
                map.put(tmp,e+1);
            }
            else{
                map.put(tmp,1);
            }
        }
        int max_value=Integer.MIN_VALUE;
        List<Map.Entry<Integer,Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> {
            if (Objects.equals(o2.getValue(), o1.getValue())) {
                return o1.getKey() - o2.getKey();
            }
            return o2.getValue() - o1.getValue();
        });
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list);
        bw.write((int) Math.round(sum/a)+"\n");
        bw.write(list.get((int) Math.floor(a/2.0))+"\n");
        if(entryList.size()>1) {
            if (Objects.equals(entryList.get(0).getValue(), entryList.get(1).getValue()))
                bw.write(entryList.get(1).getKey() + "\n");
            else bw.write(entryList.get(0).getKey() + "\n");
        }
        else bw.write(entryList.get(0).getKey() + "\n");
        bw.write(max-min+"\n");
        bw.flush();
    }
}
