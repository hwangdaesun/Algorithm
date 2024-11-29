package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_폴리오미노 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String A = "AAAA";
        String B = "BB";

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        boolean flag = false;
        for(int i=0; i<input.length(); i++){
            if(input.charAt(i) == 'X') {
                cnt++;
            }
            if (input.charAt(i) == '.') {
                if(cnt % 2 == 0){
                    int a = cnt / 4;
                    int b = (cnt - 4*a) / 2;
                    for(int j=0; j<a; j++){
                        sb.append(A);
                    }
                    for(int j=0; j<b; j++){
                        sb.append(B);
                    }
                    cnt = 0;
                    sb.append(".");
                }
                else{
                    flag = true;
                    break;
                }
            }
            if(i == input.length() - 1){
                if(cnt % 2 == 0){
                    int a = cnt / 4;
                    int b = (cnt - 4*a) / 2;
                    for(int j=0; j<a; j++){
                        sb.append(A);
                    }
                    for(int j=0; j<b; j++){
                        sb.append(B);
                    }
                    cnt = 0;
                }
                else{
                    flag = true;
                    break;
                }
            }
        }

        if(flag){
            System.out.println(-1);
        }else {
            System.out.println(sb.toString());
        }
    }
}
