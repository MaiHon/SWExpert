package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW1221 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testN = Integer.valueOf(st.nextToken());
        int caseN = 0;

        while(testN-->0){
            caseN++;

            String[] input = br.readLine().split(" ");
            int len = Integer.valueOf(input[1]);

            PriorityQueue<Input> q = new PriorityQueue<Input>(new GNSComparator());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len; i++){
                q.offer(new Input(st.nextToken()));
            }

            sb.append("#" + caseN + " ");
            while(!q.isEmpty()){
                sb.append(q.poll().s + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

class Input{
    String s;

    Input(String s) {
        this.s = s;
    }

}


class GNSComparator implements Comparator<Input>{
    public int compare(Input s1, Input s2){
        int rtn = 0;

        switch (s1.s){
            case "ZRO":
                rtn = -1;
                break;

            case "ONE":
                if(s2.s.equals("ZRO")) rtn = 1;
                else rtn = -1;
                break;

            case "TWO":
                if(s2.s.equals("ZRO") || s2.s.equals("ONE")) rtn = 1;
                else rtn = -1;
                break;

            case "THR":
                if(s2.s.equals("ZRO") || s2.s.equals("ONE") || s2.s.equals("TWO")) rtn = 1;
                else rtn = -1;
                break;

            case "FOR":
                if(s2.s.equals("ZRO") || s2.s.equals("ONE") || s2.s.equals("TWO")) rtn = 1;
                else if(s2.s.equals("THR")) rtn = 1;
                else rtn = -1;
                break;

            case "FIV":
                if(s2.s.equals("SIX") || s2.s.equals("SVN") || s2.s.equals("EGT")) rtn = -1;
                else if(s2.s.equals("NIN")) rtn = -1;
                else rtn = 1;
                break;

            case "SIX":
                if(s2.s.equals("SVN") || s2.s.equals("EGT")) rtn = -1;
                else if(s2.s.equals("NIN")) rtn = -1;
                else rtn = 1;
                break;

            case "SVN":
                if(s2.s.equals("EGT")) rtn = -1;
                else if(s2.s.equals("NIN")) rtn = -1;
                else rtn = 1;
                break;

            case "EGT":
                if(s2.s.equals("NIN")) rtn = -1;
                else rtn = 1;
                break;

            case "NIN":
                rtn = 1;
                break;
        }

        return rtn;
    }
}