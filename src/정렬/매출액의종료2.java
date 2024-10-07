package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 매출액의종료2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        HashMap<Integer, Integer> hmap = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        int p = 0;
        for(int i=0; i<n-k+1; i++){
            if(i != 0){
                Integer it = hmap.get(input[i-1]);
                if(it == 1){
                    hmap.remove(input[i-1]);
                }else {
                    hmap.put(input[i-1], it-1);
                }
            }
            int j = i+k;
            while(p < j){
                if(hmap.containsKey(input[p])){
                    Integer it = hmap.get(input[p]);
                    hmap.put(input[p], ++it);
                }else{
                    hmap.put(input[p],1);
                }
                p++;
            }
            ans.add(hmap.size());
        }

        ans.stream().forEach(a -> System.out.print(a + " "));
        
    }
}
