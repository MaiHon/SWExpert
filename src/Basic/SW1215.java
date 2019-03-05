package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SW1215 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testN = 10;
        int caseN = 0;

        while(testN-->0){
            caseN++;

            int len = Integer.valueOf(br.readLine());
            char[] chs = br.readLine().toCharArray();
            int N = chs.length;

            char[][] map = new char[N][N];
            boolean[][] visit = new boolean[N][N];
            for(int i=0; i<N; i++){
                map[0][i] = chs[i];
            }

            for(int i=1; i<N; i++){
                chs = br.readLine().toCharArray();
                for(int j=0; j<N; j++){
                    map[i][j] = chs[j];
                }
            }

            int ans = 0;

            // horizontal
            int k = 0;
            while(k<N){
                for(int j=0; j<N; j++) {
                    int l = j;


                    for (int t=len-1; t>0; t--) {
                        if (j+t>=N) break;
                        if (map[k][l]!=map[k][j+t]) break;

                        l++;
                        if (l >= j+t) {
                            ans++;
                            break;
                        }
                    }
                }
                k++;
            }

            //vertical
            k = 0;
            while(k<N){
                for(int i=0; i<N; i++) {
                    int l = i;


                    for(int t=len-1; t>0; t--){
                        if(i+t>=N) break;
                        if(map[l][k]!=map[i+t][k]) break;

                        l++;
                        if(l >= i+t) {
                            ans++;
                            break;
                        }
                    }
                }
                k++;
            }
            sb.append("#" + caseN + " " + ans+"\n");
        }
        System.out.println(sb);
    }
}
