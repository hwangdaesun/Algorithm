package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_후보추천하기 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.valueOf(br.readLine());
        int n = Integer.valueOf(br.readLine());
        int age = 0;
        LinkedList<Candidate> candidates = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<n; i++){
            int k = Integer.valueOf(st.nextToken());
            age++;
            boolean flag = false;
            for(int m=0; m<candidates.size(); m++){
                if(candidates.get(m).k == k){
                    flag = true;
                    candidates.get(m).like += 1;
                }
            }

            if(!flag){
                Candidate candidate = new Candidate(age, k);
                if(candidates.size() < size){
                    candidates.offer(candidate);
                }else{
                    // 추천수가 제일 작으며 오래된 사진 찾기
                    Candidate replaced = candidates.get(0);
                    for(int j=1; j< candidates.size(); j++){
                        Candidate candidate1 = candidates.get(j);
                        if(candidate1.like < replaced.like){
                            replaced = candidate1;
                        } else if (candidate1.like == replaced.like) {
                            if(candidate1.age < replaced.age){
                                replaced = candidate1;
                            }
                        }
                    }
                    replaced.like = 0;
                    replaced.age = age;
                    replaced.k = k;
                }
            }
        }

        candidates.sort(Comparator.comparing(candidate -> candidate.k));
        while(!candidates.isEmpty()){
            System.out.print(candidates.poll().k + " ");
        }
    }


    public static class Candidate implements Comparable<Candidate>{
        public int age;
        public int k;
        public int like;

        public Candidate(int age, int k) {
            this.age = age;
            this.k = k;
            this.like = 0;
        }

        @Override
        public String toString() {
            return "Candidate{" +
                    "age=" + age +
                    ", k=" + k +
                    ", like=" + like +
                    '}';
        }

        @Override
        public int compareTo(Candidate o) {
            // 내림차순 정렬

            if(this.like > o.like) {
                return 1;
            } else if (this.like == o.like){
                if(this.age > o.age){
                    return 1;
                }
                return -1;
            }else {
                return -1;
            }


        }


    }
}
