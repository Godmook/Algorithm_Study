package Baekjoon;

        import java.io.*;
        import java.util.*;
        import java.util.stream.Collectors;

public class P_10816 {
    static final List<Integer> cur = new ArrayList<>();
    static int [] find;
    static int upperbound(int key){
        int start=0;
        int end=cur.size();
        int mid;
        while(start<end){
            mid=(start+end)/2;
            if(cur.get(mid)>key){
                end=mid;
            }
            else start=mid+1;
        }
        return end;
    }
    static int lowerbound(int key){
        int start=0;
        int end=cur.size();
        int mid;
        while(start<end){
            mid=(start+end)/2;
            if(cur.get(mid)>=key){
                end=mid;
            }
            else start=mid+1;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=null;
        int tmp=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<tmp;i++){
            cur.add(Integer.parseInt(st.nextToken()));
        }
        int b=Integer.parseInt(br.readLine());
        st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        Collections.sort(cur);
        for(int i=0;i<b;i++){
            int e=Integer.parseInt(st.nextToken());
            sb.append(upperbound(e)-lowerbound(e)+" ");
        }
        System.out.println(sb);
    }
}
