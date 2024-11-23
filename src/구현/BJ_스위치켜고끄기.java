package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_스위치켜고끄기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        int[] switches = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Integer m = Integer.valueOf(br.readLine());
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.valueOf(st.nextToken());
            int number = Integer.valueOf(st.nextToken());
            if(gender == 1){
                int multiple = switches.length / number;
                for(int j=1; j<=multiple; j++){
                    change(switches, j*number-1);
                }
            }else{
                reverseAll(switches, number-1);
            }
        }
        print(switches);

    }

    public static void change(int[] switches, int idx){
        if(switches[idx] == 0){
            switches[idx] = 1;
        }else{
            switches[idx] = 0;
        }
    }

    public static void reverseAll(int[] switches, int idxTarget){
        int range = Math.min(idxTarget, switches.length-1 - idxTarget);
        change(switches, idxTarget);
        for(int i=1; i<=range; i++){
            if(switches[idxTarget -i] == switches[idxTarget + i]){
                change(switches, idxTarget -i);
                change(switches, idxTarget +i);
            }else{
                break;
            }
        }
    }

    public static void print(int[] switches){
        for(int i=0; i<switches.length; i++){
            System.out.print(switches[i] + " ");
            if((i+1) % 20 == 0) {
                System.out.println();
            }
        }
    }
}
