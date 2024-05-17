package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문장속단어 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] split = line.split(" ");

        int maxL = 0;
        String ans = "";

        for(String s : split){
            if(s.length() > maxL){
                maxL = s.length();
                ans = s;
            }
        }

        System.out.println(ans);
    }
}
