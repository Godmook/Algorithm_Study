package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_6064 {
    private static int gcd(int x, int y){
        int tmp,n;
        if(x<y){
            tmp=x;
            x=y;
            y=tmp;
        }
        while(y!=0){
            n=x%y;
            x=y;
            y=n;
        }
        return x;
    }
    private static int lcm(int x,int y){
        return (x*y)/gcd(x,y);
    }
    static int [] s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String a=br.readLine();
        for(int i=0;i<Integer.parseInt(a);i++) {
            int ans=-1;
            s=new int[4];
            s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int max_year=lcm(s[0],s[1]);
            int max_repeat=max_year/s[0];
            for(int j=0;j<=max_repeat;j++){
                if(j==max_repeat&&s[2]!=0)continue;
                int result_year=s[0]*j+s[2];
                if(result_year%s[1]==s[3] || result_year%s[1]==0 && s[3]==s[1]){
                    ans=result_year;
                    break;
                }
            }
            bw.write(Integer.toString(ans)+"\n");
        }
        bw.flush();
    }
}
