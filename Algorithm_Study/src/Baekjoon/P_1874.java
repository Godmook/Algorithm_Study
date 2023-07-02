package Baekjoon;

import javax.annotation.processing.SupportedSourceVersion;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P_1874 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder=new StringBuilder();
        String cnt=br.readLine();
        ArrayList<Integer> list= new ArrayList<>();
        stack=new Stack<>();
        for(int i = 0; i < Integer.parseInt(cnt);i++){
            String k=br.readLine();
            list.add(Integer.parseInt(k));
        }
        boolean isPrinted=false;
        boolean isYes=true;
        int pos=1;
        for(int i = 0; i<Integer.parseInt(cnt);i++){
            int target=list.get(i);
            //System.out.println("Target="+target+" pos="+i);
            for(int j=pos;j<=Integer.parseInt(cnt)+1;j++){
                pos=j;
                if(j<=target){
                    stack.add(j);
                    stringBuilder.append("+\n");
                }
                if(j>target){
                    if(!stack.isEmpty()) {
                        int mm=stack.pop();
                        //System.out.println("Popping="+mm);
                        if (mm != target) {
                            if(!isPrinted) {
                                System.out.print("NO");
                                isYes = false;
                                isPrinted=true;
                            }
                        }
                        stringBuilder.append("-\n");
                        break;
                    }
                }
            }
        }
        if(isYes)System.out.print(stringBuilder);
    }
}
