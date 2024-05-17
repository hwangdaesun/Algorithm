package 해쉬또는정렬지원Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 매출액의종류1 {

    public static void main(String arsgs[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int n = nk[0];
        int k = nk[1];

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        List<Integer> ans = new ArrayList<>();

        for(int i=0; i<n-k+1; i++){
            List<Integer> a = new ArrayList<>();
            a.clear();
            int j = i + k;
            for(int m=i; m<j; m++){
                a.add(input[m]);
            }
            Set<Integer> set = new HashSet<>(a);
            ans.add(set.size());
            set.clear();
        }

        ans.stream().forEach((a) -> System.out.print(a + " "));
    }
}
