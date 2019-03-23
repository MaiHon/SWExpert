package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SW2819 {
    private static int ans;
//    private static String[][] map;
    private static int[][] map;
//    private static HashMap<String, Integer> chk;
    private static HashMap<Integer, Integer> chk;

    private static int[] Xdir = new int[]{1, 0, -1, 0};
    private static int[] Ydir = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.valueOf(br.readLine());
        for(int testcase=1; testcase<=T; testcase++){
            map = new int[4][4];

            for(int i=0; i<4; i++){
                st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<4; j++){
                    map[i][j] = Integer.valueOf(st.nextToken());
                }
            }

            ans = 0;
            chk = new HashMap<>();

            for(int i=0; i<4; i++){
                for(int j=0; j<4; j++){
                    dfs(0, 0, j, i);
                }
            }

            sb.append("#" + testcase + " " + ans + "\n");
        }
        System.out.println(sb);
    }

//    private static void dfs(int depth, String num, int px, int py){
//        if(depth==7){
//            if(chk.containsKey(num)) return;
//            else{
//                chk.put(num, 1);
//                ans++;
//                return;
//            }
//        }
//
//        for(int i=0; i<4; i++){
//            int nx = px + Xdir[i];
//            int ny = py + Ydir[i];
//
//            if(nx<0 || ny<0 || nx>=4 | ny>=4) continue;
//
//            num = num.concat(map[py][px]);
//            dfs(depth+1, num, nx, ny);
//            int size = num.length();
//            num = num.substring(0, size-1);
//        }
//    }



    private static void dfs(int depth, int num, int px, int py){
        if(depth==7){
            if(chk.containsKey(num)) return;
            else{
                chk.put(num, 1);
                ans++;
                return;
            }
        }

        for(int i=0; i<4; i++){
            int nx = px + Xdir[i];
            int ny = py + Ydir[i];

            if(nx<0 || ny<0 || nx>=4 | ny>=4) continue;

            dfs(depth+1, num*10 + map[ny][nx] , nx, ny);
        }
    }
}
