package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_K번째수 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Arrays.sort(req);

        for(int i=0; i<n; i++){
            if(i == k-1){
                System.out.println(req[i]);
            }
        }
    }
}
