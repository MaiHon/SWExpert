package Basic;

import java.util.*;
import java.io.*;

public class SW1949 {
    static int T, N, K, ans;
    static int[][] map;

    static boolean[][] visited1;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.valueOf(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());

            map = new int[N][N];
            visited1 = new boolean[N][N];

            int max = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.valueOf(st.nextToken());
                    if(map[i][j]>=max) max = map[i][j];
                }
            }

            ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==max){
                        visited1[i][j] = true;
                        dfs(j, i, 1, false);
                        visited1[i][j] = false;
                    }
                }
            }
            System.out.println(ans);
        }
    }


    static void dfs(int x, int y, int len, boolean d){
        ans = Math.max(len, ans);

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(ny<0 || nx<0 || nx>=N || ny>=N) continue;
            if(visited1[ny][nx]) continue;
            if(!d){
                if(map[y][x]>map[ny][nx]){
                    visited1[ny][nx] = true;
                    dfs(nx, ny, len+1, false);
                    visited1[ny][nx] = false;
                }else if(map[y][x]<=map[ny][nx]){
                    for(int j=1; j<=K; j++){
                        if(map[y][x]<=map[ny][nx]-j) continue;

                        visited1[ny][nx] = true;
                        map[ny][nx] -= j;
                        dfs(nx, ny, len+1, true);
                        map[ny][nx] += j;
                        visited1[ny][nx] = false;
                    }
                }
            }else{
                if(map[y][x]>map[ny][nx]){
                    visited1[ny][nx] = true;
                    dfs(nx, ny, len+1, true);
                    visited1[ny][nx] = false;
                }
            }
        }
    }
}