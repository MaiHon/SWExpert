package Basic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SW1248 {
    private static int V, E, A, B, parent, subM;
    private static boolean[] chk;

    private static ArrayList<Integer>[] cnt;
    private static ArrayList<Integer>[] tree;

    public static void main(String arsgs[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//            BufferedReader br = new BufferedReader(new FileReader("/Users/mah/Desktop/input.txt"));
            StringTokenizer st;
            StringBuilder sb = new StringBuilder();

            int testN = Integer.valueOf(br.readLine().trim());
            for(int i=1; i<=testN; i++){
                st = new StringTokenizer(br.readLine().trim());
                V = Integer.valueOf(st.nextToken());
                E = Integer.valueOf(st.nextToken());
                A = Integer.valueOf(st.nextToken());
                B = Integer.valueOf(st.nextToken());

                tree = new ArrayList[V+1];
                cnt = new ArrayList[V+1];

                for(int j=1; j<=V; j++){
                    tree[j] = new ArrayList<>();
                    cnt[j] = new ArrayList<>();
                }


                chk = new boolean[V+1];

                st = new StringTokenizer(br.readLine().trim());
                for(int j=1; j<=E; j++){
                    int parent = Integer.valueOf(st.nextToken());
                    int child = Integer.valueOf(st.nextToken());

                    tree[child].add(parent);
                    cnt[parent].add(child);
                }

                parent = 0;
                subM = 0;
                findParent(A, B);
                sumN(parent);

                sb.append("#" + i + " " + parent + " " + ++subM + "\n");
            }
            System.out.println(sb);

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void findParent(int A, int B){
        boolean isA = A==1;
        boolean isB = B==1;

        while(!isA || !isB){
            if(A==1) isA = true;
            if(B==1) isB = true;

            if(!isA){
                A = tree[A].get(0);
                if(chk[A]){
                    parent = A;
                    return;
                }
                chk[A] = true;
            }

            if(!isB){
                B = tree[B].get(0);
                if(chk[B]){
                    parent = B;
                    return;
                }
                chk[B] = true;
            }
        }
    }

    private static void sumN(int parent){
        subM += cnt[parent].size();
        for(int i=0; i<cnt[parent].size(); i++){
            sumN(cnt[parent].get(i));
        }
    }
}