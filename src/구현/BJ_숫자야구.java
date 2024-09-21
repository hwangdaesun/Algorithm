package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_숫자야구 {
    public static int n;
    public static int[][] req;
    public static int count = 0;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        req = new int[n][3];

        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            req[i][0] = Integer.valueOf(st.nextToken());
            req[i][1] = Integer.valueOf(st.nextToken());
            req[i][2] = Integer.valueOf(st.nextToken());
        }

        for(int i=1; i<10; i++){
            for(int j=1; j<10; j++){
                for(int k=1; k<10; k++){
                    if(i==j || i==k || j==k) continue;
                    StringBuilder sb = new StringBuilder();
                    String number = sb.append(i).append(j).append(k).toString();
                    compare(number);
                }
            }
        }
        System.out.println(count);
    }

    public static void compare(String to){
        String number = to;
        boolean flag = true;
        for(int l=0; l<n; l++){
            int sCnt = 0;
            int bCnt = 0;
            for(int m=1; m<=3; m++){
                for(int n=1; n<=3; n++){
                    if(m==n && number.charAt(m-1) == String.valueOf(req[l][0]).charAt(n-1)){
                        sCnt++;
                    }
                    if(m!=n && number.charAt(m-1) == String.valueOf(req[l][0]).charAt(n-1)){
                        bCnt++;
                    }
                }
            }
            if(!(sCnt == req[l][1] && bCnt == req[l][2])){
                flag = false;
                break;
            }
        }
        if(flag) count+=1;
    }

}
