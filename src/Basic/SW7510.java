package Basic;

import java.util.Scanner;

public class SW7510 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int testN = sc.nextInt();

        for(int testCase=1; testCase<=testN; testCase++){
            int n = sc.nextInt();
            int m = n/2;

            ans = 0;
            for(int i=1; i<=m; i++){
                ans += countAns(n, m, i);
            }
            System.out.println(ans+1);
        }
    }

    private static int ans;
    private static int countAns(int n, int m, int start){
        int tmp = 0;
        for(int i=start; i<=m+1 ; i++){
            if(tmp<n) tmp += i;
            if(tmp==n) break;
            if(tmp>n) return 0;
        }

        return 1;
    }
}
