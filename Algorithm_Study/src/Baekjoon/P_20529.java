package Baekjoon;

import java.io.*;
import java.util.*;

public class P_20529 {
    static Map<String, Integer> maps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        String [] person = new String[32];
        for(int i=0;i<Integer.parseInt(a);i++){
            String b=br.readLine();
            StringTokenizer st=new StringTokenizer(br.readLine());
            if(Integer.parseInt(b)>32)bw.write("0\n");
            else{
                String max_val="";
                int max_cnt=0;
                int final_ans=12;
                person= new String[32];
                maps= new HashMap<>();
                for(int j=0;j<Integer.parseInt(b);j++) {
                    String tmp = st.nextToken();
                    person[j]=tmp;
                    maps.put(tmp, maps.getOrDefault(tmp, 0) + 1);
                    if(maps.get(tmp)>max_cnt){
                        max_cnt=maps.get(tmp);
                        max_val=tmp;
                    }
                }
                if(max_cnt>2)bw.write("0\n");
                else{
                    for(int k=0;k<Integer.parseInt(b);k++){
                        for(int n=k+1;n<Integer.parseInt(b);n++){
                            for(int m=n+1;m<Integer.parseInt(b);m++){
                                int case_1=0;
                                for(int x=0;x<4;x++){
                                    if(person[k].charAt(x)!=person[n].charAt(x))case_1++;
                                }
                                int case_2=0;
                                for(int x=0;x<4;x++){
                                    if(person[k].charAt(x)!=person[m].charAt(x))case_2++;
                                }
                                int case_3=0;
                                for(int x=0;x<4;x++){
                                    if(person[n].charAt(x)!=person[m].charAt(x))case_3++;
                                }
                                //System.out.println(person[k]+" "+person[n]+" "+person[m]+" "+case_1+" "+case_2+" "+case_3);
                                if(case_1+case_2+case_3<final_ans)final_ans=case_1+case_2+case_3;
                            }
                        }
                    }
                    bw.write(Integer.toString(final_ans)+"\n");
                }
            }
        }
        bw.flush();
    }
}
