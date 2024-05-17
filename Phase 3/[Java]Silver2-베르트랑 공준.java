package boj_problems;

import java.io.*;

/*
* 문제 링크: https://www.acmicpc.net/problem/4948
* 문제 레벨: 실버 2
* 알고리즘: 에라토스테네스의 체
* -> 소수를 판별할 때 배수를 소거하여 연산 횟수를 줄일 수 있어 효율적이다.
* */

public class P4948 {
    public static void main(String[] args) throws IOException {
        /* 입력값 세팅 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        /* 에라토스테네스의 체를 이용해 소수를 판별한다. */
        while (true) {
            int t = Integer.parseInt(br.readLine());  // 테스트 케이스
            int count = 0;

            if (t == 0)  // 입력이 0인 경우 루프를 종료한다.
                break;

            for (int i = t + 1; i <= t * 2; i++)  // t보다 크고 2t보다 작거나 같은 소수의 개수를 출력하기 위한 범위 설정
                if(isPrime(i))  // 소수인 경우 count 증가
                    count++;
            sb.append(count).append("\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    /* 소수 판별 메서드 */
    public static boolean isPrime(int n) {
        int i = 2;  // 1과 2는 소수이므로 2부터 루프를 시작한다.
        while (i * i <= n) {  // n의 제곱근의 횟수만큼 루프를 돌린다.
            if (n % i == 0)  // 나누어 떨어지면 소수가 아니다.
                return false;
            i++;
        }
        return true;
    }
}
