package Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ6731 {
    private static int N, ans;
    private static char[][] map;

    private static boolean isFinish;
    private static boolean[][] visited;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int testN = Integer.valueOf(br.readLine());
            for(int i=1; i<=testN; i++){
                N = Integer.valueOf(br.readLine());
                map = new char[N][N];
                visited = new boolean[N][N];

                for(int j=0; j<N; j++){
                    char[] chars = br.readLine().toCharArray();
                    for(int k=0; k<N; k++){
                        map[j][k] = chars[k];
                    }
                }

                isFinish = false;
                ans = 0;
                dfs(0, visited);
                System.out.println(ans);
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void dfs(int depth, boolean[][] visited){
        // ans값 할당 후에 리턴되면 계속 리턴
        if(isFinish){
            return;
        }

        // 끝났는지 체크
        chk();

        // 끝났으면 ans값 할당
        if(isFinish){
            ans = depth;
            return;
        }

        boolean[][] copy = new boolean[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                copy[i][j] = visited[i][j];
            }
        }


        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(copy[i][j]) continue;
//                if(map[i][j]=='W') continue;

                change(i, j);
                chgBoolean(copy, i, j);

                for(boolean[] arr : copy){
                    System.out.println(Arrays.toString(arr));
                }System.out.println();

                for(char[] arr : map){
                    System.out.println(Arrays.toString(arr));
                }System.out.println();

                dfs(depth+1, copy);
                copyArray(visited, copy);
                change(i, j);
            }
        }
    }

    private static void change(int y, int x){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(i==y || j==x){
                    switch(map[i][j]){
                        case 'W':
                            map[i][j] = 'B';
                            break;
                        case 'B':
                            map[i][j] = 'W';
                            break;
                    }
                }
            }
        }
    }

    private static void chk(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]=='B'){
                    isFinish = false;
                    return;
                }
                isFinish = true;
            }
        }
    }

    private static void chgBoolean(boolean[][] copy, int y, int x){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(copy[i][j]) continue;
                if(i==y || j==x){
                    copy[i][j] = true;
                }
            }
        }
    }

    private static void copyArray(boolean[][] origin, boolean[][] to){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                to[i][j] = origin[i][j];
            }
        }
    }
}
