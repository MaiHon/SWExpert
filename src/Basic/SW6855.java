package Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW6855 {
    private static int N, K, ans;
    private static int[] list;
    private static boolean[] chk;

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
                chk = new boolean[N];

                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    list[j] = Integer.valueOf(st.nextToken());
                }

                if(N<=K){
                    sb.append("#" + i + " " + 0 + "\n");
                }else{
                    ans = Integer.MAX_VALUE;
                    dfs(0);
                    sb.append("#" + i + " " + ans + "\n");
                }
            }
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static void dfs(int depth){
        if(depth==K){
            int dis = calDis(list, chk);
            ans = Math.min(ans, dis);
            return;
        }

        for(int i=0; i<N; i++){
            if(chk[i]) continue;

            chk[i] = true;
            dfs(depth+1);
            chk[i] = false;
        }
    }

    private static int calDis(int[] list, boolean[] chk){
        int dis = 0;

        for(int i=0; i<N; i++){
            if(chk[i]) continue;
            int tmpDis = Integer.MAX_VALUE;
            for(int j=0; j<N; j++){
                if(chk[j]){
                    tmpDis = Math.min(tmpDis, Math.abs(list[i]-list[j]));
                }
            }
            dis += tmpDis;
        }


        return dis;
    }
}
