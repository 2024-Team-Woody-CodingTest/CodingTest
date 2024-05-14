/*
 * 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * 레벨: level2
 * 알고리즘: 구현
 */
import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 입력받은 두 문자열을 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 두 글자씩 나눠서 저장할 리스트 생성
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // 첫 번째 문자열을 순회하며 알파벳 소문자로 이루어진 두 글자씩의 조합을 list1에 저장
        for(int i = 0; i < str1.length() - 1; i++){
            char ch1 = str1.charAt(i);
            char ch2 = str1.charAt(i + 1);
            if((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')){
                list1.add(ch1 + "" + ch2);
            }
        }

        // 두 번째 문자열을 순회하며 마찬가지로 list2에 저장
        for(int i = 0; i < str2.length() - 1; i++){
            char ch1 = str2.charAt(i);
            char ch2 = str2.charAt(i + 1);
            if((ch1 >= 'a' && ch1 <= 'z') && (ch2 >= 'a' && ch2 <= 'z')){
                list2.add(ch1 + "" + ch2);
            }
        }

        // 두 리스트를 정렬
        Collections.sort(list1);
        Collections.sort(list2);

        // 교집합과 합집합을 계산할 리스트
        List<String> list3 = new ArrayList<>(); // 교집합
        List<String> list4 = new ArrayList<>(); // 합집합

        // list1을 순회하며 list2에서 같은 요소를 찾아 교집합에 추가하고 합집합에도 추가
        // 순회하면서 제거
        for(String s : list1){
            if(list2.remove(s)){
                list3.add(s);
            }
            list4.add(s);
        }

        // list2에 남은 요소들은 합집합에 추가
        for(String s : list2){
            list4.add(s);
        }

        // 자카드 유사도 계산
        double temp = 0;
        if(list4.size() == 0){ // 합집합의 크기가 0이면 유사도는 1
            temp = 1;
        }else{
            temp = (double)list3.size() / (double)list4.size();
        }

        // 결과를 정수형으로 반환 (65536을 곱한 후 정수형으로 변환)
        return (int)(temp * 65536);
    }
}
