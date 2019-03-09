package Basic;

import java.io.*;
import java.util.StringTokenizer;

public class SW1244 {
    static int[] numArray;
    static int len, swapN, max;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testN = Integer.valueOf(st.nextToken());
        for(int i=1; i<=testN; i++){
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            swapN = Integer.parseInt(st.nextToken());

            len = num.length();
            numArray = new int[len];

            for(int j=0; j<len; j++){
                numArray[j] = num.charAt(j) - '0';
            }

            max = 0;
            dfs(0, 0);
            bw.write("#" + i + " " + max + "\n");
        }
        bw.close();
    }

    private static void dfs(int index, int depth) {
        if (depth == swapN) {
            int val = 0;
            int j = 1;
            for(int i=numArray.length-1; i>=0; i--){
                val += numArray[i] * j;
                j *= 10;
            }

            max = Math.max(max, val);
            return;
        }

        for (int i=index; i<numArray.length; i++) {
            for (int j=i+1; j<numArray.length; j++) {
                if (numArray[j] >= numArray[i]) {
                    swap(i, j);
                    dfs(i, depth + 1);
                    swap(i, j);
                }
            }
        }
    }

    private static void swap(int a, int b) {
        int temp = numArray[a];
        numArray[a] = numArray[b];
        numArray[b] = temp;
    }
}
