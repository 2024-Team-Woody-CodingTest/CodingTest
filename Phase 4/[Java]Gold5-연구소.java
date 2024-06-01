/*
문제링크: https://www.acmicpc.net/problem/14502
레벨: Gold5
알고리즘: bfs, dfs, 그래프, 구현
풀이
1. dfs를 이용하여 벽을 3개 세우는 메소드 작성
    1-1. 백트래킹 기법을 활용하여 벽 3개 완료되면 바이러스 확산 시작
2. bfs를 이용하여 벽을 3개 세우면 바이러스를 퍼뜨리는 메소드 실행
    2-1. 매번 실행 때마다 맵을 복사해서 바이러스 퍼트리고 안전영역 체크
    2-2. 모든 바이러스 퍼트린 후 안전영역 개수 확인
    2-3. 최대 안전영역 계산
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] map;
    static int N, M;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M]; 

        // 연구소 맵 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0); // 벽을 세우는 DFS 시작

        System.out.println(answer); // 결과 출력
    }

    // 벽을 세우는 DFS 메소드
    public static void dfs(int wall) {
        if (wall == 3) { // 벽이 3개 세워졌을 때
            bfs(); // 바이러스 퍼뜨리기 시뮬레이션 시작
            return;
        }

        // 연구소의 모든 위치를 탐색하여 벽을 세우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { // 빈 공간일 때
                    map[i][j] = 1; // 벽 세우기
                    dfs(wall + 1); // 다음 벽 세우기
                    map[i][j] = 0; // 원래대로 되돌리기
                }
            }
        }
    }

    // 바이러스 퍼뜨리기 시뮬레이션을 위한 BFS 메소드
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] virusMap = new int[N][M]; // 바이러스 퍼뜨리기를 위한 맵 복사

        // 맵 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
            }
        }

        // 바이러스가 있는 모든 위치를 큐에 추가
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // BFS를 이용해 바이러스를 퍼뜨리기
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                    continue; // 맵의 경계를 벗어나는 경우 무시
                }
                if (virusMap[nx][ny] == 0) { // 빈 공간일 때
                    virusMap[nx][ny] = 2; // 바이러스 퍼뜨리기
                    q.add(new int[]{nx, ny});
                }
            }
        }

        // 안전 영역의 크기 계산
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count); // 최대 안전 영역 크기 갱신
    }
}

