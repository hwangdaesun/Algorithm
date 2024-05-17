package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class 가장짧은문자거리 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String[] strs = str.split(" ");

        String[] s = strs[0].split("");
        String t = strs[1];

        // s를 순회, 같은 t있나 비교 해당 인덱스 저장
        ArrayList<Integer> index = new ArrayList<>();

        for(int i=0; i< s.length; i++){
            if(s[i].equals(t)){
                index.add(i);
            }
        }

        int[] ans = new int[s.length];
        for(int i=0; i<ans.length ; i++){
            ans[i] = Integer.MAX_VALUE;
        }

        // index 개수만큼 순회
        for(int i=0;i<index.size();i++){
            // s 순회하면서 인덱스 - s의 인덱스 차 저장
            for(int j=0; j<s.length; j++){
                if(ans[j] > Math.abs(index.get(i) - j)){
                    ans[j] = Math.abs(index.get(i) - j);
                }
            }

        }

        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }

    }
}
