package Basic;

import java.io.*;
import java.util.StringTokenizer;

public class SW7088 {
    static int A, B, C;
    static int[] one, two;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testN = Integer.valueOf(st.nextToken());
        int caseN = 0;

        while(testN-->0){
            caseN++;

            bw.write("#" + caseN + "\n");
            st = new StringTokenizer(br.readLine());
            A = Integer.valueOf(st.nextToken());
            B = Integer.valueOf(st.nextToken());

            one = new int[A+1];
            two = new int[A+1];

            for(int i=1; i<=A; i++){
                int cowN = Integer.valueOf(br.readLine());

                if(cowN==1){
                    one[i] += 1;
                }else if(cowN==2){
                    two[i] += 1;
                }

                one[i] = one[i-1] + one[i];
                two[i] = two[i-1] + two[i];
            }

            for(int i=0; i<B; i++){
                st = new StringTokenizer(br.readLine());
                A = Integer.valueOf(st.nextToken());
                C = Integer.valueOf(st.nextToken());

                bw.write(one[C]-one[A-1] + " ");
                bw.write(two[C]-two[A-1] + " ");
                bw.write(C-A+1-one[C]+one[A-1]-two[C]+two[A-1] + "\n");
            }
        }
        bw.flush();
    }
}
