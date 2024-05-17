package 문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 암호 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String it = br.readLine();
        Integer x = Integer.valueOf(it);
        String str = br.readLine();

        //0,7 / 7,14 / 14,21 / 21,28

        List<String> q = new ArrayList<>();
        for(int i=0; i<x; i++){
            q.add(i,str.substring(i*7,(i+1)*7));
        }

        List<Integer> qa = new ArrayList<>();
        // #->1 , *->0
        for(int j=0; j<q.size(); j++){
            String ans = "";
            for(int k=0; k<q.get(j).length(); k++){
                if(q.get(j).charAt(k) == '#'){
                    ans += 1;
                }else{
                    ans += 0;
                }
            }
            qa.add(Integer.parseInt(ans,2));
            ans = "";
        }
        System.out.println(qa);

        String real ="";

        for(int m=0; m<qa.size(); m++){
            real += (char)((int)qa.get(m));
        }

        System.out.println(real);

    }
}
