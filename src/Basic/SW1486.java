package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1486 {
    static int N, B, min;
    static int[] heights;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testN = Integer.valueOf(st.nextToken());
        int caseN = 0;

        while(testN-->0){
            caseN++;

            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            B = Integer.valueOf(st.nextToken());

            heights = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                heights[i] = Integer.valueOf(st.nextToken());
            }

            min = Integer.MAX_VALUE;
            for(int i=0; i<N; i++){
                dfs(0, i);
            }
            sb.append("#" + caseN + " " + (min-B) + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int val, int idx){
        if(val>=B){
            min = Math.min(val, min);
            return;
        }

        for(int i=idx; i<N; i++){
            dfs(val+heights[idx], i+1);
        }
    }
}
