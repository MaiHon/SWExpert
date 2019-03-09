package Basic;

import java.io.*;

public class SW7103_v2 {
    static int N, ans;
    static int[] pow = new int[182];
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        for(int i=1; i < pow.length; i++) {
            pow[i] = i*i;
        }

        int testN = Integer.valueOf(br.readLine().trim());
        for(int i=1; i<=testN; i++){
            N = Integer.parseInt(br.readLine().trim());

            ans = 0;
            comb(0, 0, 1);
            sb.append("#" + i + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    public static void comb(int sum, int depth, int cnt) {
        if(depth == 4) {
            return;
        }

        for(int i=cnt; i < pow.length; i++) {
            int temp = sum + pow[i];
            if(temp > N) {
                return;
            }else if(temp == N) {
                ans++;
                return;
            }
            comb(temp, depth+1, i);
        }
    }
}
