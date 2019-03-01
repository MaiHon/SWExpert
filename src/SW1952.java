import java.util.*;
import java.io.*;

public class SW1952 {
    static int min;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testN = Integer.valueOf(st.nextToken());
        int c = 0;
        while(testN-->0){
            c++;
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            int[] price = new int[4];
            price[0] = Integer.valueOf(st.nextToken());
            price[1] = Integer.valueOf(st.nextToken());
            price[2] = Integer.valueOf(st.nextToken());
            price[3] = Integer.valueOf(st.nextToken());

            int[] plan = new int[13];
            int[] sum = new int[13];


            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=12; i++){
                int date = Integer.valueOf(st.nextToken());
                plan[i] = Math.min(date * price[0], price[1]);
            }

            sum[1] = plan[1];
            sum[2] = sum[1] + plan[2];

            for(int i=3; i<=12; i++){
                sum[i] = Math.min(sum[i-1]+plan[i], sum[i-3]+price[2]);
            }

            min = Math.min(sum[12], price[3]);
            sb.append("#" + c + " " + min);
            System.out.println(sb);
        }
    }
}
