package 해쉬또는정렬지원Set;

import java.awt.print.Pageable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 모든이나그램찾기 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split("");
        String[] s = br.readLine().split("");

        int tl = t.length;
        int sl = s.length;
        int ans = 0;

        HashMap<String,Integer> hashMap = new HashMap<>();

        HashMap<String, Integer> hashS = new HashMap<>();
        for(int k=0; k< sl; k++){
            if(hashS.containsKey(s[k])){
                hashS.put(s[k],hashS.get(s[k]) + 1);
            }else{
                hashS.put(s[k],1);
            }
        }


        int p=0;
        for(int i=0; i<tl-sl+1; i++){
            int j=i+sl;
            if(i != 0){
                Integer il = hashMap.get(t[i-1]);
                if(il > 1){
                    hashMap.put(t[i-1], il - 1);
                }else{
                    hashMap.remove(t[i-1]);
                }
            }
            while(p < j){
                if(hashMap.containsKey(t[p])){
                    Integer il = hashMap.get(t[p]);
                    hashMap.put(t[p], il + 1);
                }else {
                    hashMap.put(t[p],1);
                }
                p++;
            }

            if(hashMap.size() == hashS.size()){
                boolean flag = true;

                for(String key : hashMap.keySet()){
                    Integer keyN = hashMap.get(key);
                    Integer keyS = hashS.getOrDefault(key,0);
                    if(keyN != keyS){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans ++;
                }
        }
        }
        System.out.println(ans);
    }
}
