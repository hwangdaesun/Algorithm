package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BJ_이삿짐센터 {

    public static int limit = 5;
    public static List<Integer> ans = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> inputs = Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList());

        for(int i=inputs.size()-1; i>=0; i--){
            int t = inputs.get(i);// 해당 무게의 개수

            for(int k=0; k<t; k++){
                int weight = i+1;
                if(ans.isEmpty()){
                    ans.add(weight);
                }else{
                    List<Integer> copyAns = new ArrayList<>(ans);
                    for(int j=0; j<copyAns.size(); j++){
                        if(limit - ans.get(j) >= weight){
                            ans.set(j,ans.get(j) + weight);
                            break;
                        }
                        if(j == copyAns.size() - 1){
                            ans.add(weight);
                            break;
                        }
                    }
                }

            }
        }

        System.out.println(ans.size());
    }
}
