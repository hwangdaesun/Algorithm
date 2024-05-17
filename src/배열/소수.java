package 배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 소수 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int answer = 0;

        int[] ch = new int[n+1];
        for(int i=2; i<=n; i++){
            if(ch[i] == 0){
                answer++;
                for(int j=i; j<=n; j=j+i){
                    ch[j] = 1;
                }
            }
        }
        System.out.println(answer);

    }
}
