package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_에라토스테네스의체 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int N = array[0];
        int K = array[1];

        int count = 0;
        int p = 0;
        int before = 0;
        int[] req = new int[N + 1];
        for (int i = 2; i < req.length; i++) {
            req[i] = i;
        }

        while (count != K) {
            for (int i = 2; i <= N; i++) {
                if(req[i] != 0){
                    p = req[i];
                    before = p;
                    req[i] = 0;
                    count++;
                    break;
                }
            }
            if (count == K){
                break;
            }
            int mul = N / p;
            for (int i = 2; i <= mul; i++) {
                if(req[p * i] != 0){
                    before = req[p * i];
                    req[p * i] = 0;
                    count++;
                }
                if (count == K) break;
            }
            if (count == K) break;
        }
        System.out.println(before);
    }

}
