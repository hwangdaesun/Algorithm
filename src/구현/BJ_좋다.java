package 구현;

import java.io.*;
import java.util.*;
public class BJ_좋다 {
    static int n;
    static int[] ans;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        ans = new int[n];
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for(int i=0; i<n; i++){
            check(req, i);
        }

        int sol = 0;
        for(int i=0; i<n; i++){
            if(ans[i] == 1){
                sol++;
            }
        }
        System.out.println(sol);
    }

    private static void check(int[] req, int i) {
        for(int j = 0; j< n; j++){
            if(i == j) continue;
            for(int k = j+1; k< n; k++){
                if(i == k) continue;
                if(req[i] == req[j] + req[k]){
                    ans[i] = 1;
                    break;
                }
            }
        }
    }
}
