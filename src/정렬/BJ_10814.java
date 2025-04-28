package 정렬;

import java.io.*;
import java.util.*;
public class BJ_10814 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.valueOf(br.readLine());

        List<Member> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Integer age = Integer.valueOf(st.nextToken());
            String name = st.nextToken();
            Member member = new Member(age, name);
            ans.add(member);
        }

        Collections.sort(ans, (m1, m2) -> {
           if(m1.age < m2.age){
               return -1;
           }else if(m1.age > m2.age){
               return 1;
           }else{
               return 0;
           }
        });

        for(int i=0; i<n; i++){
            System.out.println(ans.get(i).age + " " + ans.get(i).name);
        }
    }

    public static class Member{
        public int age;
        public String name;

        public Member(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
