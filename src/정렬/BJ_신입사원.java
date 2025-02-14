package 정렬;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_신입사원 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer tc = Integer.valueOf(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<tc; i++){
            Integer n = Integer.valueOf(br.readLine());
            int count = 1;
            List<Person> persons = new ArrayList<>();

            for(int j=0; j<n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                Integer x = Integer.valueOf(st.nextToken());
                Integer y = Integer.valueOf(st.nextToken());
                Person person = new Person(x, y);
                persons.add(person);
            }

            // 서류 순으로 정렬
            persons.sort(new Comparator<Person>() {
                @Override
                public int compare(Person o1, Person o2) {
                    if(o1.x > o2.x){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            });

            // 서류 순으로 다시 확인
            int bound = persons.get(0).y;
            for(int j=1; j<persons.size(); j++){
                if(bound > persons.get(j).y){
                    count++;
                    bound = persons.get(j).y;
                }
            }

            sb.append(count);
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }

    public static class Person{

        public int x;
        public int y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
