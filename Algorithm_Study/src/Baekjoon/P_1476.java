package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for(int i=1;;i++){
            if((i-s[0])%15==0 && (i-s[1])%28==0 && (i-s[2])%19==0){
                bw.write(Integer.toString(i));
                bw.flush();
                break;
            }
        }
    }
}
