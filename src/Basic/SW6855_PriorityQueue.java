package Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW6855_PriorityQueue {
    private static int N, K;
    private static int[] list;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            int testN = Integer.valueOf(st.nextToken());
            for(int i=1; i<=testN; i++){
                st = new StringTokenizer(br.readLine());
                N = Integer.valueOf(st.nextToken());
                K = Integer.valueOf(st.nextToken());

                list = new int[N];

                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    list[j] = Integer.valueOf(st.nextToken());
                }

                PriorityQueue<Integer> q = new PriorityQueue<>();
                for(int j=0; j<N-1; j++){
                    q.offer(list[j+1] - list[j]);
                }

                if(N<=K){
                    sb.append("#" + i + " " + 0 + "\n");
                }else{
                    int res = 0;
                    int cnt = 0;
                    while(!q.isEmpty()){
                        int tmp = q.poll();
                        res += tmp;
                        cnt++;

                        if(cnt==N-K) break;
                    }
                    sb.append("#" + i + " " + res + "\n");
                }
            }
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

}
