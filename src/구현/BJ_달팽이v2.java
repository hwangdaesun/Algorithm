package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_달팽이v2 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        Integer k = Integer.valueOf(br.readLine());

        int[][] ans = new int[n][n];
        int sr = 0;
        int sc = 0;
        int ansR = 0;
        int ansC = 0;

        int[] dirR = new int[]{1,0,-1,0};
        int[] dirC = new int[]{0,1,0,-1};

        int j = 4;
        for(int i=n*n; i>0; i--){
            ans[sr][sc] = i;
            if(i == k){
                ansR = sr;
                ansC = sc;
            }
            sr += dirR[j % 4];
            sc += dirC[j % 4];
            if(!(sr < n && sr >= 0 && sc < n && sc >= 0 && ans[sr][sc] == 0)){
                sr -= dirR[j % 4];
                sc -= dirC[j % 4];
                j++;
                sr += dirR[j % 4];
                sc += dirC[j % 4];
            }
        }


        for(int i=0; i<ans.length; i++){
            for(int m=0; m<ans[i].length; m++){
                System.out.print(ans[i][m] + " ");
            }
            System.out.println();
        }
        int rr = ansR + 1;
        int cc = ansC + 1;
        System.out.println(rr + " " + cc);

    }
}
