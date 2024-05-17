package 투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 두배열합치기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Integer m = Integer.valueOf(br.readLine());
        int[] b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int k=0;
        int i=0;
        int j=0;

        int[] ans = new int[n+m];

        while(k<n+m){
            if(i == n){
                ans[k] = b[j];
                k++;
                j++;
            } else if (j == m) {
                ans[k] = a[i];
                k++;
                i++;
            } else if(a[i] <= b[j]){
                ans[k] = a[i];
                i++;
                k++;
            }else if (a[i] > b[j]){
                ans[k] = b[j];
                j++;
                k++;
            }
        }

        for(int h=0;h<n+m;h++){
            System.out.print(ans[h] + " ");
        }

    }
}
