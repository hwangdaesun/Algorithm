package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 단어뒤집기 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        Integer n = Integer.valueOf(line);
        List<String> words = new ArrayList<>();

        for(int i=0; i<n ; i++){
            String word= br.readLine();
            words.add(word);
        }

        List<String> ans = new ArrayList<>();
        for(String x : words){
            char[] s = x.toCharArray();
            int lt = 0;
            int rt = x.length() - 1;
            while(lt < rt){
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt ++;
                rt --;
            }
            String tmp = String.valueOf(s);
            ans.add(tmp);
        }

        ans.stream().forEach((x) -> System.out.println(x));

    }

}
