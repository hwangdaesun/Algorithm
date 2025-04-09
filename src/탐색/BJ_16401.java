package 탐색;

import java.io.*;
import java.util.*;
public class BJ_16401 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer m = Integer.valueOf(st.nextToken());
        Integer n = Integer.valueOf(st.nextToken());

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        long left = 0;
        long right = Integer.MAX_VALUE;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += input[i] / mid;
            }

            if (sum < m) {
                right = mid -1;
            } else {
                left = mid;
            }
        }

        System.out.println(left);
    }
}
