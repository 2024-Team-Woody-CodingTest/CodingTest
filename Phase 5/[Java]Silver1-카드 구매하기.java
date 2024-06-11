import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 문제 링크: https://www.acmicpc.net/problem/11052
 * 문제 레벨: 실버 1
 * 알고리즘: DP
 * -> 점화식을 찾아 DP로 해결할 수 있다!
 * */

public class P11052 {
    static int N;

    static int[] P = new int[1001];
    //  1개 구입 시 최댓값 D[1], 2개 구입 시 최댓값: D[2], 3개 구입 시 최댓값: D[3], ...
    static int[] D = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        StringTokenizer st = new StringTokenizer(input);
        for (int i = 1; i <= N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * D[1]은 카드가 1개일 때의 값이므로, D[1] = D[0] + P[1] = 1
        * D[2] = D[0] + P[2] = 0 + 5
        * D[3] = D[1] + P[2] = 1 + 5 = 6
        * D[4] = D[2] + P[2] = 5 + 5 = 10
        * 1) D[i] = D[i-4] + P[4]
        * 2) D[i] = D[i-3] + P[3]
        * 3) D[i] = D[i-2] + P[2]
        * 4) D[i] = D[i-1] + P[1]
        * 점화식은 D[i] = max(D[i], D[i-j] + P[j])
        * */
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                D[i] = Math.max(D[i], D[i-j] + P[j]);
            }
        }

        System.out.println(D[N]);
    }
}
