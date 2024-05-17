package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자만추출 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        // 숫자 여부
        String ans = "";
        for(int i =0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))){
                ans += str.charAt(i);
            }
        }

        Integer integer = Integer.valueOf(ans);
        System.out.println(integer);

    }
}
