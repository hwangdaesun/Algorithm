package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_DNA비밀번호 {

    static int[] limit = new int[4]; // A,C,G,T
    static int[] count = new int[4];
    static String req;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nl = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nl[0];
        int l = nl[1];
        req = br.readLine();


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i=0; i<4; i++){
            limit[i] = Integer.valueOf(st.nextToken());
        }

        for(int i=0; i<l; i++){
            char tmp = req.charAt(i);
            if(tmp == 'A') count[0]++;
            if(tmp == 'C') count[1]++;
            if(tmp == 'G') count[2]++;
            if(tmp == 'T') count[3]++;
        }

        int ans = 0;
        ans += check();

        for(int i=0; i+l<n; i++) {
            char tmp = req.charAt(i);
            if(tmp == 'A') count[0]--;
            if(tmp == 'C') count[1]--;
            if(tmp == 'G') count[2]--;
            if(tmp == 'T') count[3]--;

            char tmp2 = req.charAt(i+l);
            if(tmp2 == 'A') count[0]++;
            if(tmp2 == 'C') count[1]++;
            if(tmp2 == 'G') count[2]++;
            if(tmp2 == 'T') count[3]++;
            ans += check();
        }
        System.out.println(ans);
    }

    public static int check(){
        for(int k=0; k<4; k++){
            if(limit[k] > count[k]){
                return 0;
            }
        }
        return 1;
    }


}
