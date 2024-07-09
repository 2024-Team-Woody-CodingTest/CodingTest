import java.util.*;
import java.io.*;

/*
 * 문제 링크: https://www.acmicpc.net/problem/2644
 * 문제 레벨: 실버 2
 * 알고리즘: BFS
 * */

public class P2644 {
    // 변수 선언(전체 사람 수, 관계 수, 시작점, 도착점, 그래프, 거리 배열)
    static int n, m, start, end;
    static int[][] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        dist = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());

        // 관계 입력 및 그래프 구성
        for(int i=0; i<m; i++){
            st =  new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1; // 무방향 그래프로 만들기 위해
        }

        bfs(start);

        // 촌수가 0이면 관계가 없으므로 -1, 아니면 촌수 출력
        System.out.println(dist[end] == 0 ? -1 : dist[end]);
    }

    // BFS
    public static void bfs(int index){
        // 큐 선언, 시작점 추가
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(index);

        // 큐가 빌 때까지 반복
        while(!q.isEmpty()){
            // 현재 노드 추출하고 현재 노드가 도착점이면 종료
            int temp = q.poll();

            if(temp == end) break;

            // 인접 노드 탐색
            for(int i=1; i<=n; i++){
                // 인접하고 방문하지 않은 노드는 큐에 추가하고 촌수를 갱신한다
                if(graph[temp][i]==1 && dist[i]==0){
                    q.add(i);
                    dist[i] = dist[temp]+1;
                }
            }
        }
    }
}