package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class 중복문자제거 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String ans = "";
        for(int i=0; i<str.length(); i++){
            if(str.indexOf(str.charAt(i)) == i){
                ans+=str.charAt(i);
            }
        }
        System.out.println(ans);
    }
}
