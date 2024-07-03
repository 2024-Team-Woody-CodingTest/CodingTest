import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 문제 링크: https://www.acmicpc.net/problem/10282
 * 문제 레벨: 골드 5
 * 알고리즘: 다익스트라 알고리즘 
 *
 * [문제]
 *  - 네트워크 시설의 한 컴퓨터가 해킹되면, 서로 의존하는 컴퓨터들이 점차 전염된다.
 *  - 컴퓨터 a가 컴퓨터 b에 의존한다면, b가 감염된 후 일정 시간 뒤 a도 감염된다.
 *  - 해킹된 컴퓨터 번호와 각 의존성이 주어질 때, 총 몇 대의 컴퓨터가 감염되고, 그에 걸리는 시간은 얼마인지 구하는 프로그램을 작성하시오.
 * 
 * [로직]
 *  - 다익스트라 알고리즘을 사용하여 최단 시간을 구한다.
 *  - 시작 노드를 해킹당한 컴퓨터로 설정하고, 각 컴퓨터까지의 최단 시간을 구한 후, 
 *    감염된 컴퓨터의 수와 마지막 컴퓨터가 감염되기까지 걸리는 시간을 계산한다.
 *
 * */

public class Main {

    private static int n,d,c;
    private final static int INF = (int) 1e9;
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] dis = new int[10001];

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        StringTokenizer st;

        //2

        //3 2 2

        //2 1 5
        //3 2 5

        //3 3 1

        //2 1 2
        //3 1 8
        //3 2 4

        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(st.nextToken()); //컴퓨터 개수
            d = Integer.parseInt(st.nextToken()); //의존성 개수
            c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호

            graph = new ArrayList<>();

            // 그래프 초기화
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            // 그래프 입력
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(reader.readLine());

                int a = Integer.parseInt(st.nextToken()); // 컴퓨터 a가
                int b = Integer.parseInt(st.nextToken()); // 컴퓨터 b를 의존
                int s = Integer.parseInt(st.nextToken()); // b가 감염되면 s초후 a도 감염됨

                graph.get(b).add(new Node(a, s)); // b가 감염되면 s초 후 a도 감염
            }

            Arrays.fill(dis, INF); // 최단 시간 배열을 무한대로 초기화

            dijkstra(c); // 다익스트라 알고리즘 실행

            int cnt = 0;
            int result = 0;
            for (int i=1; i<=n; i++) {
                if (dis[i] != INF) {
                    cnt++;
                    result = Math.max(result, dis[i]);  // 감염된 컴퓨터 카운트 및 최대 시간 계산
                }
            }

            sb.append(cnt + " " + result + "\n");

        }

        System.out.print(sb);

    }

    // 다익스트라 알고리즘
    private static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작 노드 초기화
        dis[start] = 0; // 시작 노드의 최단 시간은 0

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int dist = node.distance;
            int now = node.index;

            if (dis[now] < dist) { // 현재 노드의 최단 시간이 이미 계산된 경우 무시
                continue;
            }

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = dis[now] + graph.get(now).get(i).getDistance();

                if (cost < dis[graph.get(now).get(i).getIndex()]) { // 더 짧은 경로 발견 시 업데이트
                    dis[graph.get(now).get(i).getIndex()] = cost;
                    pq.add(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    // 노드 클래스 정의 (우선순위 큐 사용을 위해 Comparable 인터페이스 구현)
    static class Node implements Comparable<Node> {
        int index, distance;
        Node (int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        private int getIndex() {
            return this.index;
        }

        private int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node o) {
            if (this.distance < o.distance) {
                return -1;
            }
            return 1;
        }
    }
}
