package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_이삿짐센터2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] bk = new int[3001];

        for(int i=req.length-1; i>=0; i--){
            if(req[i] >= 1){
                for(int k=1; k<=req[i]; k++){
                    for(int j=0; j<bk.length; j++){
                        if(bk[j] + (i+1) <= 5){
                            bk[j] += (i+1);
                            break;
                        }
                    }
                }
            }
        }
        int count = 0;
        for (int i: bk) {
            if(i >= 1){
                count ++;
            }
            if(i == 0){
                break;
            }
        }
        System.out.println(count);

    }
}
