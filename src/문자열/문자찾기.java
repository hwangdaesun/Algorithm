package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자찾기 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        String cr = br.readLine();

        String uWord = word.toUpperCase();
        char uc = cr.toUpperCase().charAt(0);

        int answer = 0;
        for(char x : uWord.toCharArray()){
            if(uc == x){
                answer++;
            }
        }

        System.out.println(answer);
    }

}
