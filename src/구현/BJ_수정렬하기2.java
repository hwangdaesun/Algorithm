package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_수정렬하기2 {

    static int[] req;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        req = new int[n];
        for(int i=0; i<n; i++){
            req[i] = Integer.valueOf(br.readLine());
        }
        Arrays.sort(req);

        StringBuilder st = new StringBuilder();
        for(int i=0; i<n; i++){
            st.append(req[i]).append("\n");
        }

        System.out.println(st.toString());

    }
}
