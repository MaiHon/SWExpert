package Basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SW1767 {
    static int N, core, size, min;
    static int[][] Mxynos;

    static boolean[] visited;
    static ArrayList<int[]> coreList;
    static PriorityQueue<Core> q;

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

            min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());

            core = 0;
            visited = new boolean[N];
            coreList = new ArrayList<>();
            q = new PriorityQueue<>();
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
            dfs(0, 0, 0, 0);

            Core first = q.poll();
            int min = first.min;
            int connect = first.connect;

            for(Core c : q){
                if(connect<=c.connect){
                    if(c.min<min){
                        min = c.min;
                        connect = c.connect;
                    }
                }
            }

            sb.append("#" + caseN + " " + min + "\n");
        }
        System.out.println(sb);
    }

    static void dfs(int depth, int cable, int idx, int con){
        if(depth==core){
            q.add(new Core(con, cable));
            min = Math.min(min, cable);

            return;
        }

        for(int i=idx; i<size; i++){
            if(visited[i]) continue;

            int[] now = coreList.get(i);
            visited[i] = true;

            for(int d=0; d<4; d++){
                int ncable = cntCable(now[1], now[0], d, depth+2);
                if(ncable>=0) dfs(depth+1, ncable + cable, i, con+1);
                else if(d==3 && ncable<0) dfs(depth+1, cable, i, con);
                back(now[1], now[0], d, depth+2);
            }

            visited[i] = false;
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

class Core implements Comparable<Core>{
    int connect;
    int min;

    Core(int con, int min){
        this.connect = con;
        this.min = min;
    }

    @Override
    public int compareTo(Core o) {
        if(this.connect < o.connect) return 1;
        else if(this.connect == o.connect) return 0;
        else return -1;
    }
}