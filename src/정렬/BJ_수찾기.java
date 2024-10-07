package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_수찾기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] req = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        for(int i=0; i<n; i++){
            map.put(req[i],1);
        }
        Integer m = Integer.valueOf(br.readLine());
        int[] req2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        StringBuilder st = new StringBuilder();
        for(int i=0; i<m; i++){
            Integer value = map.get(req2[i]);
            if(value == null){
                st.append(0).append('\n');
            } else{
                st.append(value).append('\n');
            }
        }
        System.out.println(st);
    }
}
