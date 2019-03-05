package Basic;

import java.util.Scanner;

public class SW1217 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb;

        int testC = 10;
        while(testC-->0){
            sb = new StringBuilder();
            int caseN = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            int ans = power(N, M);
            sb.append("#" + caseN + " " + ans);
            System.out.println(sb);
        }

    }


    static int power(int n, int m){
        int ans = 1;
        if(m==0) return ans;
        else return n*power(n, m-1);
    }
}
