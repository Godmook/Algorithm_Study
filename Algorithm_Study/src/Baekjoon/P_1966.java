package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Pair{
    private int idx;
    private int importance;
    Pair (){
        this.idx=-1;
        this.importance=-1;
    }
    Pair(int idx,int importance){
        this.idx=idx;
        this.importance=importance;
    }
    public int getIdx(){
        return idx;
    }
    public int getImportance(){
        return importance;
    }
}
public class P_1966 {
    static Queue<Pair> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        int a=Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int size=Integer.parseInt(st.nextToken());
            int idx=Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine());
            queue=new LinkedList<>();
            Pair tmp=new Pair();
            for(int j=0;j<size;j++){
                int e=Integer.parseInt(st.nextToken());
                if(j==idx)tmp=new Pair(j,e);
                queue.offer(new Pair(j,e));
            }
            int ans=0;
            boolean isTrue=true;
            while(isTrue) {
                Pair target=queue.stream().max((o1,o2)->{
                    return o1.getImportance()-o2.getImportance();
                }).get();
                while(true){
                    Pair tt=queue.element();
                    if(tt.getImportance()==target.getImportance()){
                        if(tt.getImportance()==tmp.getImportance() && tt.getIdx()==tmp.getIdx()){
                            isTrue= false;
                        }
                        queue.remove(target);
                        ans++;
                        break;
                    }
                    else{
                        Pair x=queue.poll();
                        queue.offer(x);
                    }
                }
            }
            bw.write(Integer.toString(ans)+"\n");
        }
        bw.flush();
    }
}
