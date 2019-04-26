package Basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW7272 {
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;

            int T = Integer.valueOf(br.readLine().trim());
            for(int tc=1; tc<=T; tc++){
                st = new StringTokenizer(br.readLine().trim());
                String first = st.nextToken();
                String second = st.nextToken();

                boolean isSame = chk(first, second);
                if(isSame) sb.append("#" + tc + " " + "SAME\n");
                else sb.append("#" + tc + " " + "DIFF\n");
            }
            System.out.println(sb);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    private static boolean chk(String f, String s){
        int[] first = toChar(f);
        int[] second = toChar(s);

        int fsize = first.length;
        int ssize = second.length;

        if(fsize!=ssize) return false;

        for(int i=0; i<fsize; i++){
            if(first[i]!=second[i]) return false;
        }

        return true;
    }

    private static int[] toChar(String str){
//        char[] tmp = str.toCharArray();
        int tmp[] = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='B') tmp[i] = 2;
            else if(str.charAt(i)=='A' || str.charAt(i)=='D' || str.charAt(i)=='O') tmp[i] = 1;
            else if(str.charAt(i)=='P' || str.charAt(i)=='Q' || str.charAt(i)=='R') tmp[i] = 1;
        }

        return tmp;
    }
}