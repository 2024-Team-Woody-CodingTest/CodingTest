// 백준 실버 3 https://www.acmicpc.net/problem/13417
// 그리디 

/*
<< 받은 카드 들을 왼쪽이나 오른쪽으로 놓았을 때 가장 사전순으로 앞에있는 문자 열을 출력하는 문제 , 단 한쪽에서만 카드를 가져올수 있다>>

- 카드를 왼쪽 또는 오른쪽에 놓는 동작이 반복되며, 이러한 작업을 효율적으로 수행하기 위해 Deque를 사용
- Deque 자료구조 : 양쪽 끝에서의 삽입과 삭제가 O(1) 시간에 가능하다. 
    deque.add(char): deque에 카드를 추가
    deque.addFirst(char): deque의 맨 앞에 카드를 추가 (문자가 deque의 첫 번째 카드보다 더 작거나 같은 경우)
    deque.addLast(char): deque의 맨 끝에 카드를 추가 (문자를 deque의 마지막 카드와 비교해 더 큰 경우) 
    deque.peekFirst(): deque의 첫 번째 카드를 반환
    deque.pollFirst(): deque의 첫 번째 카드를 제거(꺼낸다) -> 결과 생성에 사용 
    -----
예) BACABAC 
    1) B
    2) (A)B
    3) AB(C)    
    4) (A)ABC
    5) AABC(B)
    6) (A)AABCB
    7) AAABCB(C) => AAABCBC

 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 import java.util.Deque;
 import java.util.LinkedList;
 import java.util.StringTokenizer;
 
 public class Main {
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int T = Integer.parseInt(br.readLine()); 
         StringBuilder sb = new StringBuilder(); 
 
         // 각 테스트 케이스 반복
         while (T-- > 0) { 
             int N = Integer.parseInt(br.readLine()); 
             StringTokenizer st = new StringTokenizer(br.readLine());   // 문자 공백 구분하여 입력 받음
             Deque<Character> deque = new LinkedList<>();               // Deque를 이용하여 카드 문자열 생성
 
             for (int i = 0; i < N; i++) { 
                 char card = st.nextToken().charAt(0); // 문자열에서 문자로 변환해 카드변수로
                 if (deque.isEmpty()) {                 // deque 가 비어있으면 바로 추가 ! 
                     deque.add(card);
                 } else {
                    // 비어있지 않을 경우 값을 비교한 후 저장한다. 
                     if (deque.peekFirst() >= card) {    // 첫번째 카드가 크거나 같으면 맨 앞에 추가 
                         deque.addFirst(card);
                     } else {                              // 그렇지 않으면 맨 뒤에 추가 
                         deque.addLast(card);
                     }
                 }
             }

             // Deque가 비어있지 않을 때까지
             while (!deque.isEmpty()) { 
                 sb.append(deque.pollFirst()); //첫 번째 카드를 꺼내어 결과에 추가
             }
             System.out.println(sb.toString());
         }
     }
 }
 
