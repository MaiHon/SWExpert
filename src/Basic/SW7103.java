package Basic;

import java.io.*;

public class SW7103 {
    static int N, cnt;
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testN = Integer.valueOf(br.readLine().trim());

        for(int i=1; i<=testN; i++){
            N= Integer.valueOf(br.readLine().trim());

            cnt = 0;
            int[] nums = new int[(int)Math.sqrt(N)+1];

            for(int j=1; j<nums.length; j++){
                nums[j] = N/(j*j);
            }

            count(nums, 0, nums.length-1, 0);
            bw.write("#" + i + " " + cnt + "\n");
        }
        bw.close();
    }

    static void count(int[] nums, int depth, int idx, int val){
        if(depth>4 || val>N){
            return;
        }

        if(val==N){
            cnt++;
            return;
        }

        for(int i=idx; i>=1; i--){
            if(nums[i]==0) continue;

            nums[i]--;
            count(nums, depth+1, i, val + i*i);
            nums[i]++;
        }
    }
}