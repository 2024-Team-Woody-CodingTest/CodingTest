## 문제 링크

[](https://www.acmicpc.net/problem/9205)

## 코드

## 풀이

```java
import java.io.*;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        String[] input;
        
        for (int test = 0; test < t; test++) {
            // 맥주를 파는 편의점 개수
            int n = Integer.parseInt(br.readLine());
            
            input = br.readLine().split(" ");
            
            // 상근이네 집 좌표
            int[] s = new int[2];
            s[0] = Integer.parseInt(input[0]);
            s[1] = Integer.parseInt(input[1]);
            
            // 편의점 좌표
            int[][] p = new int[n][2];
            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                
                p[i][0] = Integer.parseInt(input[0]);
                p[i][1] = Integer.parseInt(input[1]);
            }
            
            // 펜타포트 락 페스티벌 좌표
            int[] f = new int[2];
            input = br.readLine().split(" ");
            f[0] = Integer.parseInt(input[0]);
            f[1] = Integer.parseInt(input[1]);
            
            // bfs
            bfs(s, f, p, n);
        }
    }
    
    // bfs
    private static void bfs(int[] start, int[] f, int[][] p, int n) {
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[n];   // 편의점 방문 여부
        
        q.add(start);
        
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            // 페스티벌과의 거리
            int dist = manhattan(curr, f);
            
            if (dist <= 1000) {
                System.out.println("happy");
                return;
            }
            
            // 편의점이 1000m 내에 있는지 확인
            for (int i = 0; i < n; i++) {
                if (!visited[i] && manhattan(curr, p[i]) <= 1000) {
                    q.add(p[i]);
                    visited[i] = true;
                }
            }
        }
        
        System.out.println("sad");
    }
    
    // 맨해튼 거리 함수
    private static int manhattan(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
```

### 어떤 알고리즘 / 자료구조를 사용했나요?

- bfs
- 해당 문제는 플로이드 워셜로도 풀 수 있다고 한다.
    - 메모리 초과가 날 것 같긴하다.

### 해당 문제를 맞았다면 / 틀렸다면 어떻게 접근했나요?

- 상근이네 집 좌표, 편의점 좌표, 페스티벌 좌표를 순서대로 받아 bfs를 수행한다.
- 한번 방문한 편의점은 다시 방문하지 않도록 한다.
    - 해당 편의점을 방문했는데 축제까지 못가는 경우 편의점을 백번 방문해도 갈 수 없기 때문이다.
- 맥주 한 병당 50m를 갈 수 있기 때문에, 한 박스를 모두 마시면 1000m를 갈 수 있다.
    - 따라서 편의점, 페스티벌 모두 1000m이내여야만 갈 수 있다.
    - 이게 왜 통하냐면 맥주는 한 박스, 즉 20병 이상으로는 살 수 없기 떄문이다.
    - 따라서 편의점 한 번 갈 때마다 1000m씩 갈 수 있음
- 페스티벌 위치와의 거리가 1000m이내면 그냥 편의점 안가고 바로 가도 된다.
    - 근데 만약 아니라면 우선 편의점이 1000m이내인지 확인하고, 방문한 적 없는 편의점만 큐에 넣고 방문한다.
- 그 후 편의점부터 페스티벌 위치까지 구해서 이동하면 된다.
    - 만약 이동이 불가능한 경우면 sad를 출력하면 된다.