package Basic;

import java.io.*;
import java.util.StringTokenizer;

public class SW7194 {
    static int s, t, a, b;
    static int cnt;

    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int testN = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= testN; i++) {


            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());


            cnt = 0;
            goHome(i);
        }
        bw.flush();
    }

    private static void goHome(int i) throws IOException{
        if(b==1){
            int tmp = t-s;
            if(tmp%a == 0){
                bw.write("#" + i + " " + tmp/a + "\n");
            }else bw.write("#" + i + " " + -1 + "\n");
        }else{
            while(s!=t){
                if(t%b==0){
                    if(t/b < s){
                        cnt++;
                        t -= a;
                    }else{
                        cnt++;
                        t /= b;
                    }
                }else{
                    cnt++;
                    t -= a;
                }

                if(s > t){
                    bw.write("#" + i + " " + -1 + "\n");
                    return;
                }
            }
            bw.write("#" + i + " " + cnt + "\n");
        }
    }
}

