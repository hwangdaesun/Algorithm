package 해쉬또는정렬지원Set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 모든이나그램찾기2 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String t = br.readLine();
        String s = br.readLine();

        int tL = t.length();
        int sL = s.length();
        int ans = 0;

        HashMap<Character,Integer> hashT = new HashMap<>();

        HashMap<Character, Integer> hashS = new HashMap<>();
        for(int k=0; k< sL; k++){
            hashS.put(s.charAt(k), hashS.getOrDefault(s.charAt(k),0) + 1);
        }


        for(int i=0; i<sL-1; i++){
            hashT.put(t.charAt(i), hashT.getOrDefault(t.charAt(i),0) + 1);
        }


        int lt = 0;

        for(int rt = sL -1 ; rt < tL; rt++){
            hashT.put(t.charAt(rt), hashT.getOrDefault(t.charAt(rt),0) + 1);
            if(hashT.equals(hashS)){
                ans++;
            }
            hashT.put(t.charAt(lt), hashT.getOrDefault(t.charAt(lt),0) - 1);
            if(hashT.get(t.charAt(lt)) == 0){
                hashT.remove(t.charAt(lt));
            }
            lt ++;
        }
        System.out.println(ans);


    }

}
