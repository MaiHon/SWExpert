package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SW1234 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testN = 10;
        int caseN = 0;
        while(testN-->0){
            caseN++;

            String[] pretreatment = br.readLine().split(" ");
            int len = Integer.valueOf(pretreatment[0]);

            char[] before = pretreatment[1].toCharArray();
            Stack<Character> after = new Stack<>();
            Deque<Character> test = new LinkedList<>();

            for(char c : before){
                if(after.isEmpty()) after.push(c);
                else{
                    if(after.peek().equals(c)) after.pop();
                    else after.push(c);
                }
            }

//            for(char c : before){
//                if(test.isEmpty()) test.add(c);
//                else{
//                    if(test.peekLast().equals(c)) test.pollLast();
//                    else test.add(c);
//                }
//            }
            sb.append("#" + caseN + " ");
            for(char c : after){
                sb.append(c);
            }sb.append("\n");

//            for(char c : test){
//                System.out.print(c + " ");
//            }System.out.println();
        }
        System.out.println(sb);
    }
}