package Basic;

import java.util.*;
import java.io.*;

public class SW2382 {
    static int N, M, K;
    static int[][] map;
    static ArrayList<Pair>[][] micro;

    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{-1, 0, 1, 0};

    public static void main(String args[])throws IOException{
//        BufferedReader br = new BufferedReader(new FileReader("/Users/mah/Desktop/sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testN = Integer.valueOf(br.readLine());

        int c = 0;
        while(testN-->0){
            c++;
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());

            map = new int[N][N];
            micro = new ArrayList[N][N];

            Arrays.fill(map[0], -1);
            for(int i=0; i<N; i++){
                map[i][0] = map[i][N-1] = -1;
            }
            Arrays.fill(map[N-1], -1);

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    micro[i][j] = new ArrayList<>();
                }
            }

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int y = Integer.valueOf(st.nextToken());
                int x = Integer.valueOf(st.nextToken());
                int val = Integer.valueOf(st.nextToken());
                int direct = Integer.valueOf(st.nextToken());

                if(direct==1)direct = 0;
                else if(direct==2) direct = 2;
                else if(direct==3) direct = 3;
                else direct = 1;

                micro[y][x].add(new Pair(x, y, val, direct, 0));
            }

            for(int m=0; m<M; m++){
                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(micro[i][j].size()>1){
                            int idx = micro[i][j].size();

                            Pair now = micro[i][j].get(0);
                            int px = now.x;
                            int py = now.y;

                            int mval = 0;
                            int nval = 0;
                            int ndir = 0;

                            for(int k=0; k<idx; k++) {
                                now = micro[i][j].get(k);
                                if(now.val>mval) {
                                    mval = now.val;
                                    ndir = now.dir;
                                }
                                nval += now.val;
                            }

                            for(int k=0; k<idx; k++){
                                micro[i][j].remove(0);
                            }

                            micro[i][j].add(new Pair(px, py, nval, ndir, 0));
                        }

                        if(micro[i][j].size()==1){
                            micro[i][j].get(0).done = 0;
                        }
                    }
                }

                for(int i=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(micro[i][j].isEmpty()) continue;

                        int idx = micro[i][j].size();
                        int cnt = 0;
                        for(int l=0; l<idx; l++){
                            if(micro[i][j].get(l).done==1) break;
                            cnt += 1;
                            mi(micro[i][j].get(l));
                        }

                        for(int l=0; l<cnt; l++){
                            micro[i][j].remove(0);
                        }
                    }
                }
            }

            int ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!micro[i][j].isEmpty()){
                        int idx = micro[i][j].size();

                        for(int k=0; k<idx; k++){
                            ans += micro[i][j].get(k).val;
                        }
                    }
                }
            }

            System.out.println("#" + c + " " + ans);
        }
    }


    static void mi(Pair p) {
        int px = p.x;
        int py = p.y;
        int pval = p.val;
        int pdir = p.dir;

        int ny = py + dy[pdir];
        int nx = px + dx[pdir];

        if(map[ny][nx]==-1){
            pval /= 2;
            pdir = (pdir+2)%4;
        }

        micro[ny][nx].add(new Pair(nx, ny, pval, pdir, 1));
    }
}

class Pair{
    int x;
    int y;
    int val;
    int dir;
    int done;

    Pair(int x, int y, int val, int dir, int done){
        this.x = x;
        this.y = y;
        this.val = val;
        this.dir = dir;
        this.done = done;
    }
}