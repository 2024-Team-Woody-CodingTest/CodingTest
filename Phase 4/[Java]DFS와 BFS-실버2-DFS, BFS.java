package ch04_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 문제 링크: https://www.acmicpc.net/problem/1260
* 문제 레벨: 실버 2
* 알고리즘: DFS, BFS
* -> 기본적인 탐색 알고리즘!
* */

public class Prob026 {
    /* 그래프를 저장할 리스트와 방문 여부를 저장하기 위한 배열 */
    static ArrayList<Integer>[] A;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /* 입력값 세팅 */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        A = new ArrayList[N + 1];

        /* 리스트 초기화 */
        for (int i = 1; i <= N; i++)
            A[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            /* 리스트에 노드간 연결 정보를 저장한다. */
            A[S].add(E);
            A[E].add(S);
        }

        /* 문제에서 오름차순으로 탐색한다는 조건이 있어 정렬한다.*/
        for (int i = 1; i <= N; i++)
            Collections.sort(A[i]);

        /* 방문 배열을 초기화 한후 DFS를 수행한다. */
        visited = new boolean[N + 1];
        DFS(start);
        System.out.println();

        /* 다시 방문 배열을 초기화 한후 BFS를 수행한다. */
        visited = new boolean[N + 1];
        BFS(start);
        System.out.println();
    }

    static void DFS(int node) {
        /* 현재 노드를 출력한 후 방문 여부를 체크한다. */
        System.out.print(node + " ");
        visited[node] = true;
        /* 현재 노드 중 방문하지 않은 노드를 시작점으로 다시 DFS를 실행한다. */
        for (int i : A[node])
            if (!visited[i]) DFS(i);
    }

    static void BFS(int node) {
        /* 큐에 시작 노드를 삽입한다. */
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        /* 큐가 비어있을 때까지 반복 */
        while (!q.isEmpty()) {
            /* 탐색할 노드를 가져온 후 출력한다. */
            int now = q.poll();
            System.out.print(now + " ");
            /* 현재 노드의 연결 노드 중 방문하지 않은 노드를 큐에 삽입하고 방문 여부를 체크한다. */
            for (int i : A[now])
                if (!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
        }
    }
}
