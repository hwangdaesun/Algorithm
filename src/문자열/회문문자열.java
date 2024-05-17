package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 회문문자열 {

    public static void main(String args[]) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String ans = "YES";
        int len = str.length();
        for(int i=0;i<len/2;i++){
            if(str.charAt(i) != str.charAt(len-i-1)){
                ans = "NO";
                return;
            }
            System.out.println(ans);
        }
    }
}
