package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_단어뒤집기2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        boolean flag = false;
        boolean ff = false;

        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '<'){
                ans.append(sb.reverse());
                sb.setLength(0);
                ff = true;
            }
            if(c == '>') {
                ff = false;
                ans.append(c);
                continue;
            }
            if(ff) {
                ans.append(c);
                continue;
            }


            if(Character.isDigit(c) || Character.isLetter(c)) flag = true;
            if(c == ' '){
                flag = !flag;
            }
            if(flag){
                sb.append(c);
            }else{
                ans.append(sb.reverse());
                ans.append(' ');
                sb.setLength(0);
            }

            if(i == s.length() - 1) {
                String s1 = sb.reverse().toString();
                ans.append(s1);
            }
        }
        System.out.println(ans);
    }
}
