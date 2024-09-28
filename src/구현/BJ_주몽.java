package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_주몽 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        Integer m = Integer.valueOf(br.readLine());
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i == j) continue;
                if(req[i] + req[j] == m){
                    ans++;
                }
            }
        }
        System.out.println(ans/2);
    }
}
