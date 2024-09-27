package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_구간합구하기4 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] sum = new int[n];
        for(int i=0; i<n; i++){
            if(i==0) sum[i] = req[i];
            else{
                sum[i] = sum[i-1] + req[i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.valueOf(st.nextToken());
            int m = Integer.valueOf(st.nextToken());
            int ans = sum[m-1] - sum[l-1] + req[l-1];
            sb.append(ans + "\n");
            //System.out.println(sum[m-1] - sum[l-1] + req[l-1]);
        }
        System.out.println(sb);
    }
}
