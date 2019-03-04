import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW1221_v2 {
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

            PriorityQueue<V2> q = new PriorityQueue<V2>(new GNSComparator_V2());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<len; i++){
                q.offer(new V2(st.nextToken()));
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


class V2{
    String s;
    int val;

    V2(String s) {
        this.s = s;
        switch (s){
            case "ZRO":
                this.val = 0;
                break;

            case "ONE":
                this.val = 1;
                break;

            case "TWO":
                this.val = 2;
                break;

            case "THR":
                this.val = 3;
                break;

            case "FOR":
                this.val = 4;
                break;

            case "FIV":
                this.val = 5;
                break;

            case "SIX":
                this.val = 6;
                break;

            case "SVN":
                this.val = 7;
                break;

            case "EGT":
                this.val = 8;
                break;

            case "NIN":
                this.val = 9;
                break;
        }
    }

}


class GNSComparator_V2 implements Comparator<V2> {
    public int compare(V2 v1, V2 v2){
        if(v1.val < v2.val) return -1;
        else return 1;
    }
}
