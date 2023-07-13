package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Graph_1916 implements Comparable<Graph_1916>{
    private int end;
    private int weight;
    Graph_1916(int end,int weight){
        this.end=end;
        this.weight=weight;
    }
    @Override
    public int compareTo(Graph_1916 o) {
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
public class P_1916 {
    private static int[] dijkstra(ArrayList<ArrayList<Graph_1916>> graph){
        PriorityQueue<Graph_1916> pq= new PriorityQueue<>();
        pq.offer(new Graph_1916(startPoint,0));
        int [] dist = new int [town_cnt+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[startPoint]=0;
        while(!pq.isEmpty()){
            Graph_1916 curGraph=pq.poll();
            int cur=curGraph.getEnd();
            if(!visited[cur]) {
                visited[cur]=true;
                for (Graph_1916 g : graph.get(cur)) {
                    if (!visited[g.getEnd()]&&dist[g.getEnd()] > dist[cur] + g.getWeight()) {
                        dist[g.getEnd()] = dist[cur] + g.getWeight();
                        pq.add(new Graph_1916(g.getEnd(), dist[g.getEnd()]));
                    }
                }
            }
        }
        return dist;
    }
    static int town_cnt;
    static int vertex;
    static int startPoint;
    static boolean [] visited;
    static ArrayList<ArrayList<Graph_1916>> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        town_cnt= Integer.parseInt(br.readLine());
        vertex= Integer.parseInt(br.readLine());
        arrayList=new ArrayList<>();
        for(int i=0;i<town_cnt+1;i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<vertex;i++){
            int tmp[];
            tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrayList.get(tmp[0]).add(new Graph_1916(tmp[1],tmp[2]));
        }
        visited=new boolean[town_cnt+1];
        int []setting=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        startPoint=setting[0];
        int []res=dijkstra(arrayList);
        bw.write(Integer.toString(res[setting[1]]));
        bw.flush();
    }
}
