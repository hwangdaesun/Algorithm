package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_유니크 {
    static int[][] arr;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        arr = new int[n][3];

        for(int i=0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        }

        int[] ans = new int[n];

        // 순회하고, 해당 값이 있으면 flag = true 만들고, true면 해당 값 다 0처리

        for(int j=0; j<3; j++){
            for(int i=0; i<n; i++){
                int k = arr[i][j];
                if(k == 0) continue;
                for(int m=i+1; m<n; m++){
                    if(arr[m][j] == k){
                        arr[m][j] = 0;
                        arr[i][j] = 0;
                    }
                }
            }
            for(int i=0; i<n; i++){
                ans[i] += arr[i][j];
            }
        }

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i]);
            if(i != ans.length - 1){
                System.out.println();
            }
        }

    }
}
