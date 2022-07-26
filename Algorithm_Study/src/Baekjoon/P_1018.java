package Baekjoon;

import java.io.*;
import java.util.Arrays;

public class P_1018 {
    public static int Check(char [][] ans,char[][] compare,int w,int h){
        int changeB=0;
        int changeW=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(ans[i][j]!=compare[i+w][j+h]){
                    if(ans[i][j]=='B')changeB++;
                    else changeW++;
                }
            }
        }
        return changeB+changeW;
    }
    final static char [][] ansB={
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'},
        {'B','W','B','W','B','W','B','W'},
        {'W','B','W','B','W','B','W','B'}
    };
    final static char [][] ansW={
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'},
            {'W','B','W','B','W','B','W','B'},
            {'B','W','B','W','B','W','B','W'}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int min=Integer.MAX_VALUE;
        char [][] array=new char[s[0]][s[1]];
        for(int i=0;i<s[0];i++){
            for(int j=0;j<s[1];j++){
                array[i][j]=(char)(br.read());
            }
            br.read();
        }
        for(int i=0;i<s[0]-7;i++){
            for(int j=0;j<s[1]-7;j++){
                    min=Math.min(min,Check(ansW,array,i,j));
                    min=Math.min(min,Check(ansB,array,i,j));
            }
        }
        bw.write(Integer.toString(min));
        bw.flush();
    }
}
