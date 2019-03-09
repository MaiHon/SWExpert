package Basic;

import java.io.*;

public class SW7103_v3{
    public static BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw =
            new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException{
        int[] dp = new int[32769];
        int r1, r2, r3, n;
        for(int i = 1; i*i <= 32768; i++){
            r1 = i*i;
            dp[r1]++;
            for(int j = i; j*j+r1 <= 32768; j++){
                r2 = j*j+r1;
                dp[r2]++;
                for(int k = j; k*k+r2 <= 32768; k++){
                    r3 = k*k+r2;
                    dp[r3]++;
                    for(int l = k; l*l+r3 <= 32768; l++){
                        dp[l*l+r3]++;
                    }
                }
            }
        }

        int testN = Integer.valueOf(br.readLine().trim());
        for(int i=1; i<=testN; i++){
            n = Integer.parseInt(br.readLine().trim());
            bw.write("#" + i + " " + dp[n]+"\n");
        }
        bw.close();
    }
}