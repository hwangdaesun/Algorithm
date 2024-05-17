package 구현;

import java.io.*;


public class BJ_부녀회장이될테야 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            Integer k1 = Integer.valueOf(br.readLine());
            Integer n1 = Integer.valueOf(br.readLine());
            ans[i] = ans(k1,n1);
        }

        for(int i=0; i<ans.length; i++){
            System.out.println(ans[i]);
        }

    }

    public static int ans(int k1, int n1) throws IOException {
        int[][] arr1 = new int[k1+1][n1];

        for(int i=0; i< arr1.length; i++){
            for(int j=0; j<arr1[i].length; j++){
                if(i == 0){
                    arr1[i][j] = j+1;
                }else{
                    for(int m=0; m<=j; m++){
                        arr1[i][j] += arr1[i-1][m];
                    }
                }
            }
        }

        return arr1[k1][n1-1];
    }

}
