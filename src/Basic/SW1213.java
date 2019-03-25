package Basic;

import java.io.*;
import java.util.StringTokenizer;

public class SW1213 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=1; i<=10; i++){
            int ans = 0;
            br.readLine();

            String ptn = br.readLine().trim();
            String str = br.readLine().trim();

            int[] failed = failed(ptn);

            int ptnSize = ptn.length();
            int strSize = str.length();

            char[] ptns = ptn.toCharArray();
            char[] strs = str.toCharArray();

            int k=0;
            for(int j=0; j<strSize; j++) {
                while (k > 0 && strs[j] != ptns[k]) {
                    k = failed[k - 1];
                }
                if (strs[j] == ptns[k]) {
                    if (k == ptnSize - 1) {
                        ans++;
                        k = failed[k];
                    } else {
                        k++;
                    }
                }
            }

            bw.write("#" + i + " " + ans + "\n");
        }
        bw.close();
    }

    private static int[] failed(String ptn){
        int size = ptn.length();
        int[] pi = new int[size];
        char[] p = ptn.toCharArray();


        int j = 0;
        for(int i=1; i<size; i++){
            while(j>0 && p[i] != p[j]){
                j = pi[j-1];
            }
            if(p[i]==p[j]) pi[i] = ++j;
        }

        return pi;
    }
}
