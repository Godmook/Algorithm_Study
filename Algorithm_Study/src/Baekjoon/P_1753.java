package Baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Graph implements Comparable<Graph>{
    private int end;
    private int weight;
    Graph(int end,int weight){
        this.end=end;
        this.weight=weight;
    }
    @Override
    public int compareTo(Graph o) {
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
public class P_1753 {
    private static int[] dijkstra(ArrayList<ArrayList<Graph>> a) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.offer(new Graph(startPt, 0));
        int[] dist = new int[s[0] + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[startPt] = 0;

        while (!pq.isEmpty()) {
            Graph curGraph = pq.poll();
            int cur = curGraph.getEnd();

            if (!visited[cur]) {
                visited[cur] = true;

                for (Graph graph : a.get(cur)) {
                    if (!visited[graph.getEnd()] && dist[graph.getEnd()] > dist[cur] + graph.getWeight()) {
                        dist[graph.getEnd()] = dist[cur] + graph.getWeight();
                        pq.add(new Graph(graph.getEnd(), dist[graph.getEnd()]));
                    }
                }
            }
        }
        return dist;
    }
    static int []s;
    static int startPt;
    static boolean [] visited;
    static ArrayList<ArrayList<Graph>> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String startPoint=br.readLine();
        startPt=Integer.parseInt(startPoint);
        arrayList=new ArrayList<>();
        for(int i=0;i<=s[0];i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<s[1];i++){
            int tmp[];
            tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrayList.get(tmp[0]).add(new Graph(tmp[1],tmp[2]));
        }
        visited=new boolean[s[0]+1];
        int []res=dijkstra(arrayList);
        StringBuilder builder=new StringBuilder();
        for(int i=1;i<=s[0];i++){
            if(res[i]==Integer.MAX_VALUE){
                builder.append("INF\n");
            }
            else
                builder.append(res[i]+"\n");
        }
        bw.write(builder.toString());
        bw.flush();
    }
}
