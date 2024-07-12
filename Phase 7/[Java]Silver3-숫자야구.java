/*
 * 문제 링크: https://www.acmicpc.net/problem/2503
 * 문제 레벨: 실버 3
 * 알고리즘: 구현
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 

        // 가능한 숫자를 저장할 boolean 배열 생성
        boolean[] possible = new boolean[1000];
        
        // 123부터 987까지 가능한 숫자들을 탐색
        for (int i = 123; i <= 987; i++) {
            String str = String.valueOf(i);
            char first = str.charAt(0);
            char second = str.charAt(1);
            char third = str.charAt(2);

            // 각 자리 숫자가 중복되지 않고 '0'이 없는 경우만 true로 설정
            if (first != second && second != third && first != third && first != '0' && second != '0' && third != '0') {
                possible[i] = true;
            }
        }

        while (N-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String number = st.nextToken(); // 입력된 숫자
            int strike = Integer.parseInt(st.nextToken()); // 스트라이크 개수
            int ball = Integer.parseInt(st.nextToken()); // 볼 개수

            // 123부터 987까지 숫자를 탐색
            for (int i = 123; i <= 987; i++) {

                // 가능하지 않은 숫자는 건너뛰기
                if (!possible[i]) {
                    continue;
                }

                String str = String.valueOf(i);
                int strikeNum = 0;
                int ballNum = 0;

                // 스트라이크 개수 계산
                if (str.charAt(0) == number.charAt(0)) strikeNum++;
                if (str.charAt(1) == number.charAt(1)) strikeNum++;
                if (str.charAt(2) == number.charAt(2)) strikeNum++;

                // 볼 개수 계산
                if (str.charAt(0) == number.charAt(1) || str.charAt(0) == number.charAt(2)) ballNum++;
                if (str.charAt(1) == number.charAt(0) || str.charAt(1) == number.charAt(2)) ballNum++;
                if (str.charAt(2) == number.charAt(0) || str.charAt(2) == number.charAt(1)) ballNum++;

                // 주어진 스트라이크 및 볼 개수와 일치하지 않으면 가능한 숫자에서 제외
                if (strike != strikeNum || ball != ballNum) {
                    possible[i] = false;
                }
            }
        }

        // 가능한 숫자의 개수를 세기
        int count = 0;
        for (int i = 123; i <= 987; i++) {
            if (possible[i]) {
                count++;
            }
        }

        System.out.println(count);
    }
}