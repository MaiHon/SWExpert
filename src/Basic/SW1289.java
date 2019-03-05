package Basic;

import java.util.Scanner;

public class SW1289 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int testN = sc.nextInt();
        int caseN = 0;

        while(testN-->0){
            caseN++;

            String originS = sc.next();
            char[] origin = originS.toCharArray();

            char[] init = new char[origin.length];
            for(int i=0; i<init.length; i++){
                init[i] = '0';
            }

            int size = init.length;
            int cnt = 0;
            for(int i=0; i<size; i++){
                if(origin[i]==init[i]) continue;
                else{
                    for(int j=i; j<size; j++){
                        init[j] = origin[i];
                    }
                    cnt++;
                }
            }

            sb.append("#" + caseN + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}


