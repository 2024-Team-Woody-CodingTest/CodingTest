/*
 * 문제링크: https://school.programmers.co.kr/learn/courses/30/lessons/12919
 * 레벨: level1
 * 알고리즘: X
 */
class Solution {
    public String solution(String[] seoul) {
        // Kim의 위치를 저장할 변수 초기화
        int index = -1;
        for (int i = 0; i < seoul.length; i++){
            // 배열 요소가 Kim인지 검사
            if("Kim".equals(seoul[i])){
                // Kim이 발견된 위치를 저장
                index = i;
                // Kim을 찾으면 반복 종료
                break;
            }
        }
        // 결과 문자열 구성하여 반환
        return "김서방은 " + index + "에 있다";
    }
}