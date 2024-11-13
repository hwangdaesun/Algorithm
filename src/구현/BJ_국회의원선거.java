package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_국회의원선거 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        int [] inputs = new int[n];
        for(int i=0; i<n; i++){
            inputs[i] = Integer.valueOf(br.readLine());
        }

        int ansIndex = 0;
        int maxIndex = 0;
        int max = inputs[maxIndex];
        int cnt = 0;

        while(true){
            for(int i=0; i<n; i++){
                if(max <= inputs[i]){
                    max = inputs[i];
                    maxIndex = i;
                }
            }
            if(maxIndex == ansIndex){
                break;
            }

            inputs[maxIndex] = inputs[maxIndex] - 1;
            max -= 1;
            inputs[ansIndex] = inputs[ansIndex] + 1;
            cnt ++;
        }
        System.out.println(cnt);
    }
}
