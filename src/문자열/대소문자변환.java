package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 대소문자변환 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        char[] charArray = word.toCharArray();
        int i =0;
        for(char d : charArray){
            if(Character.isLowerCase(d)){
                charArray[i] = String.valueOf(d).toUpperCase().charAt(0);
            }else{
                charArray[i] = String.valueOf(d).toLowerCase().charAt(0);
            }
            i++;
        }

        System.out.println(charArray);
    }
}
