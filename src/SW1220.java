import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SW1220 {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int testC = 10;
        int idx = 0;

        while(testC-->0){
            idx++;

            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i=0; i<N; i++){
                 st = new StringTokenizer(br.readLine());
                 for(int j=0; j<N; j++){
                     map[i][j] = Integer.valueOf(st.nextToken());
                 }
            }

            magnetic();

            visited = new boolean[N][N];
            int ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(map[i][j]==1 && !visited[i][j]){
                        for(int k=1; k<N-i; k++){
                            if(map[i+k][j]==1) {
                                visited[i+k][j] = true;
                                continue;
                            }
                            if(map[i+k][j]==0) continue;

                            visited[i][j] = true;
                            ans++;
                            break;
                        }
                    }
                }
            }
            sb.append("#" + idx + " " + ans+"\n");
        }
        System.out.println(sb);
    }

    static void magnetic(){
        for(int i=N-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(map[i][j]==1 && !visited[i][j]){
                    for(int k=1; k<N-i; k++){
                        if(map[i+k][j]==2){
                            map[i+k/2][j] = 1;
                            map[i+k/2+1][j] = 2;

                            if(i!=i+k/2) map[i][j] = 0;
                            if(i+k!=i+k/2+1) map[i+k][j] = 0;

                            visited[i+k/2][j] = true;
                            visited[i+k/2+1][j] = true;
                            break;

                        }else if(map[i+k][j]==1){
                            map[i+k/2+1][j] = 1;
                            if(i!=i+k/2+1) map[i][j] = 0;

                            visited[i+k/2+1][j] = true;
                            break;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]!=0 && !visited[i][j]){
                    map[i][j] = 0;
                }
            }
        }
    }
}