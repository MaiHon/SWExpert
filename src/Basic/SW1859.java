package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW1859 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testN = Integer.valueOf(st.nextToken());
        for(int i=1; i<=testN; i++){
            int n = Integer.valueOf(br.readLine());


            int[] arr = new int[n];
            int[] max = new int[n];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                arr[j] = Integer.valueOf(st.nextToken());
            }

            int tmp = 0;
            for(int j=n-1; j>=0; j--){
                tmp = Math.max(tmp, arr[j]);
                max[j] = tmp;
            }

            long ans = 0;
            for(int j=0; j<n; j++){
                if(max[j]>=arr[j]) ans += max[j]-arr[j];
            }

            sb.append("#" + i + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}
