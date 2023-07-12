package Baekjoon;

import java.io.*;
import java.util.Stack;

public class P_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        String explosion=br.readLine();
        Stack<Character> stack= new Stack<>();
        for(int i=0;i<str.length();i++){
            stack.push(str.charAt(i));
            if(stack.size()>=explosion.length()){
                boolean isExploded=true;
                for(int j=0;j<explosion.length();j++){
                    if(stack.get(stack.size()-explosion.length()+j)!=explosion.charAt(j)){
                        isExploded=false;
                        break;
                    }
                }
                if(isExploded){
                    for(int j=0;j<explosion.length();j++){
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder builder=new StringBuilder();
        for(Character c:stack){
            builder.append(c);
        }
        if(builder.length()==0)bw.write("FRULA");
        else bw.write(builder.toString());
        bw.flush();
    }
}
