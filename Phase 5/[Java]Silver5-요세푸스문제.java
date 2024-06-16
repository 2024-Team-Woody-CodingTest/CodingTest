/*
문제링크: https://www.acmicpc.net/problem/11866
레벨: Silver5
알고리즘: 구현, 자료구조, 큐
풀이: 주석 참고
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //총 사람 수
        int N = Integer.parseInt(st.nextToken());
        //제거할 간격
        int K = Integer.parseInt(st.nextToken());

        //큐를 이용하여 사람들을 순서대로 저장한다
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            q.add(i + 1);  // 1부터 N까지의 숫자를 큐에 추가한다
        }

        // 결과를 저장할 StringBuilder를 생성한다
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 큐에 남은 사람이 한 명이 될 때까지 반복한다
        while(q.size() > 1){
            // K-1번 만큼 큐의 맨 앞 요소를 맨 뒤로 보낸다
            for(int i = 0; i < K - 1; i++){
                q.add(q.poll());
            }
            // K번째 사람을 제거하고 결과에 추가한다
            sb.append(q.poll()).append(", ");
        }
        
        // 마지막 남은 사람을 결과에 추가하고 닫는 괄호를 추가한다
        sb.append(q.poll()).append(">");
        
        System.out.println(sb);
    }
}