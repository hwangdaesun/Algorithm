package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_ATM {
    static int[] req;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int ans = 0;
        int sum = 0;

        Arrays.sort(req);

        for(int i=0; i<n; i++){
            sum += req[i];
            ans += sum;
        }

        System.out.println(ans);

    }
}
