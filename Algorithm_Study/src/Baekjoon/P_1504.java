package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Graph_1504 implements Comparable<Graph_1504>{
    private int end;
    private int weight;
    Graph_1504(int end, int weight){
        this.end=end;
        this.weight=weight;
    }
    @Override
    public int compareTo(Graph_1504 o) {
        return this.weight-o.weight;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class P_1504 {
    private static int[] dijkstra(ArrayList<ArrayList<Graph_1504>> a,int startPt) {
        PriorityQueue<Graph_1504> pq = new PriorityQueue<>();
        pq.offer(new Graph_1504(startPt, 0));
        int[] dist = new int[s[0] + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startPt] = 0;

        while (!pq.isEmpty()) {
            Graph_1504 curGraph = pq.poll();
            int cur = curGraph.getEnd();


                for (Graph_1504 graph : a.get(cur)) {
                    if (dist[graph.getEnd()] > dist[cur] + graph.getWeight()) {
                        dist[graph.getEnd()] = dist[cur] + graph.getWeight();
                        pq.add(new Graph_1504(graph.getEnd(), dist[graph.getEnd()]));
                    }
                }
        }
        return dist;
    }
    static int []s;
    static int stopPoint[];
    static ArrayList<ArrayList<Graph_1504>> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arrayList=new ArrayList<>();
        for(int i=0;i<=s[0];i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<s[1];i++){
            int tmp[];
            tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrayList.get(tmp[0]).add(new Graph_1504(tmp[1],tmp[2]));
            arrayList.get(tmp[1]).add(new Graph_1504(tmp[0],tmp[2]));
        }
        stopPoint=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans[]=new int[2];
        for(int i=0;i<2;i++) {
            int[] res = dijkstra(arrayList, 1);
            if(res[stopPoint[i]]==Integer.MAX_VALUE){
                ans[i]=-1;
                continue;
            }
            ans[i] = res[stopPoint[i]];
            res = dijkstra(arrayList, stopPoint[i]);
            if(res[stopPoint[1-i]]==Integer.MAX_VALUE){
                ans[i]=-1;
                continue;
            }
            ans[i] += res[stopPoint[1-i]];
            res = dijkstra(arrayList, stopPoint[1-i]);
            if(res[s[0]]==Integer.MAX_VALUE){
                ans[i]=-1;
                continue;
            }
            ans[i] += res[s[0]];
        }
        if(ans[0] == -1 && ans[1]==-1)bw.write("-1");
        else{
            if(ans[0]==-1){
                bw.write(Integer.toString(ans[1]));
            }
            else if(ans[1]==-1){
                bw.write(Integer.toString(ans[0]));
            }
            else{
                bw.write(Integer.toString(Math.min(ans[1],ans[0])));
            }
        }
        bw.flush();
    }
}
