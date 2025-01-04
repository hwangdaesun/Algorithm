package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2002 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<String> ins = new ArrayList<>();
        List<String> outs = new ArrayList<>();

        for(int i=0; i<n; i++){
            ins.add(br.readLine());
        }

        for(int i=0; i<n; i++){
            outs.add(br.readLine());
        }

        int outIdx = -1;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(ins.get(i).equals(outs.get(j))){
                    if(j <= outIdx){
                        break;
                    }else {
                        outIdx = j;
                        break;
                    }
                }else {
                    if(j > outIdx){
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
