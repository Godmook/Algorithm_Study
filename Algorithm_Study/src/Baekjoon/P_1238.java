package Baekjoon;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Town implements Comparable<Town>{
    private int point;
    private int weight;
    Town(int point,int weight){
        this.point=point;
        this.weight=weight;
    }
    @Override
    public int compareTo(Town o) {
        return weight-o.weight;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
public class P_1238 {
    private static int[] dijkstra(ArrayList<ArrayList<Town>> a) {
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(s[2], 0));
        int[] dist = new int[s[0] + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s[2]] = 0;

        while (!pq.isEmpty()) {
            Town curTown = pq.poll();
            int cur = curTown.getPoint();

            if (!visited[cur]) {
                visited[cur] = true;

                for (Town town : a.get(cur)) {
                    if (!visited[town.getPoint()] && dist[town.getPoint()] > dist[cur] + town.getWeight()) {
                        dist[town.getPoint()] = dist[cur] + town.getWeight();
                        pq.add(new Town(town.getPoint(), dist[town.getPoint()]));
                    }
                }
            }
        }
        return dist;
    }
    static boolean visited[];
    static int s[];
    static ArrayList<ArrayList<Town>> arrayList;
    static ArrayList<ArrayList<Town>> back_arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arrayList=new ArrayList<>();
        back_arrayList=new ArrayList<>();
        visited=new boolean[s[0]+1];
        for(int i=0;i<=s[0];i++){
            arrayList.add(new ArrayList<>());
            back_arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<s[1];i++){
            int tmp[];
            tmp=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            arrayList.get(tmp[0]).add(new Town(tmp[1],tmp[2]));
            back_arrayList.get(tmp[1]).add(new Town(tmp[0],tmp[2]));
        }
        int [] going=dijkstra(arrayList);
        visited=new boolean[s[0]+1];
        int []coming = dijkstra(back_arrayList);
        int ans=Integer.MIN_VALUE;
        for(int i=1;i<=s[0];i++)
            ans=Math.max(ans,going[i]+coming[i]);
        bw.write(Integer.toString(ans));
        bw.flush();
    }
}
