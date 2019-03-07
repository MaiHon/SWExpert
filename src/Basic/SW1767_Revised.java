package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1767_Revised {
    static int N, core, size, ans, ansCon;
    static int[][] Mxynos;
    static ArrayList<int[]> coreList;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0 ,1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testN = Integer.valueOf(st.nextToken());
        int caseN = 0;

        while(testN-->0){
            caseN++;

            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());

            core = 0;
            coreList = new ArrayList<>();
            Mxynos = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    Mxynos[i][j] = Integer.valueOf(st.nextToken());
                    if(Mxynos[i][j]!=0 && i!=0 && j!=0 && i!=N-1 && j!=N-1) {
                        coreList.add(new int[]{i, j});
                        core++;
                    }
                }
            }

            size = coreList.size();

            ans = Integer.MAX_VALUE;
            ansCon = 0;

            dfs(0, 0, 0);

            sb.append("#" + caseN + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int cable, int con) {
        if (depth == core) {
            if (con >= ansCon) {
                if (con == ansCon) {
                    ans = (cable < ans ? cable : ans);
                } else {
                    ansCon = con;
                    ans = cable;
                }
            }
            return;
        }

        int[] now = coreList.get(depth);

        int cntDir = 0;
        for (int d = 0; d < 4; d++) {
            int ncable = cntCable(now[1], now[0], d, depth + 2);

            if (ncable >= 0) {
                dfs(depth + 1, ncable + cable, con + 1);
            } else if(cntDir==2 && ncable<0){
                dfs(depth + 1, cable, con);
            }
            cntDir++;
            back(now[1], now[0], d, depth + 2);
        }
    }

    static int cntCable(int x, int y, int dir, int depth){
        int cable = 0;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while(nx>=0 && nx<N && ny<N && ny>=0){
            if(Mxynos[ny][nx]==0){
                Mxynos[ny][nx] = depth;
                cable++;
            }else{
                return -1;
            }

            ny += dy[dir];
            nx += dx[dir];
        }
        return cable;
    }

    static void back(int x, int y, int dir, int depth) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        while (nx >= 0 && nx < N && ny < N && ny >= 0) {
            if (Mxynos[ny][nx] == depth) {
                Mxynos[ny][nx] = 0;

                ny += dy[dir];
                nx += dx[dir];
            }
            else{
                return;
            }
        }
    }
}