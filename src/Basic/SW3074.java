package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW3074 {
    static int N, M, ans, maxT;
    static int[] time;

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
            M = Integer.valueOf(st.nextToken());

            time = new int[N];

            maxT = 0;
            for(int i=0; i<N; i++){
                time[i] = Integer.valueOf(br.readLine());
                if(maxT<time[i]){
                    maxT = time[i];
                }
            }

            long ans = binarySearch();
            sb.append("#" + caseN + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static long binarySearch() {
        long left = 1, right = maxT*(long)M;
        long total, mid;
        while(left <= right) {
            mid = (left+right)/2;
            total = 0;
            for(int i=0; i<N; i++) {
                total += mid/time[i];
            }
            if(total < M)
                left = mid+1;
            else
                right = mid-1;
        }
        return left;
    }
}
