package 탐색;

import java.io.*;
import java.util.*;

public class BJ_차집합 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Integer a = Integer.valueOf(st.nextToken());

        int[] inputA = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        Integer b = Integer.valueOf(st.nextToken());
        int[] inputB = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(inputB);

        List<Integer> aa = new ArrayList<>();
        int ans = 0;

        for(int i=0; i<a; i++){
            int k = binary_search(inputB, inputA[i], 0, b - 1);
            if(k == -1){
                ans++;
                aa.add(inputA[i]);
            }
        }

        System.out.println(ans);
        Collections.sort(aa);
        for(int i=0; i<aa.size(); i++){
            System.out.print(aa.get(i) + " ");
        }
    }

    public static int binary_search(int[] array, int target, int start, int end){
        if(start > end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(array[mid] == target){
            return 1;
        }else if(array[mid] > target){
            return binary_search(array, target, start, mid - 1);
        }else{
            return binary_search(array, target, mid + 1, end);
        }
    }
}
