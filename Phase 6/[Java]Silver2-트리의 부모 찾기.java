import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 문제 링크: https://www.acmicpc.net/problem/11725
 * 문제 레벨: 실버 2
 * 알고리즘: BFS
 * */

public class P11725 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        // 인접 리스트 초기화
        List<Integer> list[] = new ArrayList[N+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        // 방문 여부를 확인하기 위한 배열
        boolean visit[] = new boolean[N+1];

        // BFS를 위한 큐 초기화
        Queue<Integer> queue = new LinkedList<Integer>();

        // 루트 노드(1)부터 탐색 시작
        queue.add(1);
        visit[1] = true;

        // 각 노드의 부모 노드를 저장하기 위한 배열
        int ans[] = new int [N+1];

        // BFS를 수행하며 각 노드의 부모 노드를 찾기
        while(!queue.isEmpty()) {
            Integer num = queue.poll();
            for (Integer i : list[num]) {
                if(!visit[i]) {
                    visit[i] = true;
                    ans[i] = num;
                    queue.add(i);
                }
            }
        }

        // 2번 노드부터 N번 노드까지의 부모 노드를 출력
        for (int i = 2; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
