package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1629 {
    private static long solution(long var, long exponent){
        if(exponent==1)return var%s[2];
        long tmp= solution(var,exponent/2);
        if(exponent%2==1){
            return (tmp*tmp%s[2])*var%s[2];
        }
        return tmp*tmp%s[2];
    }
    static long []s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        s= Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        bw.write(Long.toString(solution(s[0],s[1])));
        bw.flush();
    }
}
