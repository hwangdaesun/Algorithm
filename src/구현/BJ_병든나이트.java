package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_병든나이트 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());

        if(n == 1){
            System.out.println(1);
        }
        if (n == 2) {
            System.out.println(Math.min(4,(m+1)/2));
        }
        if(n >= 3){
            if(m < 7){
                System.out.println(Math.min(4,m));
            }else{
                System.out.println(m-2);
            }
        }

    }
}
