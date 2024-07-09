/*

백준 실버1 - 극장 좌석 : https://www.acmicpc.net/problem/2302
알고리즘 : DP

[ 문제 ]
- 극장의 좌석이 한 줄로 배치되어 있으며, 각 좌석은 1번부터 N번까지 번호가 매겨져 있다. 
- 관객들은 입장권에 적힌 좌석에 앉아야 하지만, VIP 회원들은 반드시 자신들의 지정 좌석에만 앉아야 한다. 
- 일반 관객들은 자신의 좌석에서 왼쪽이나 오른쪽으로 한 칸 이동할 수 있다. 
- 주어진 좌석과 VIP 좌석 번호에 따라 가능한 좌석 배치의 경우의 수를 구한다. 

[ 로직 ]
- 일반 관객, 자신의 좌석과 왼쪽, 오른쪽으로 이동할 수 있는 경우의 수 구함
- 각 구간의 경우의 수를 계산하고 곱해준다
- N이 1일때 방법 1가지 
- N이 2일때, '1 2'. '2 1' 방법 2가지
- N이 3일때, '1 2 3' '1 3 2' '2 1 3' 방법 3가지
- N이 4일때, '1 2 3 4' '2 1 3 4' '1 3 2 4' '2 1 4 3' '1 2 4 3' 방법 5가지 
-> dp[N] = dp[N-2] + dp[N-1] 점화식 도출 (피보나치 수열) 
- VIP 좌석을 놓는 경우를 계산후 곱해준다. 

*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// 좌석개수와 고정석(VIP)개수 
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		// DP 초기화 
		int[] dp = new int[41];
		dp[0] = 1; 
		dp[1] = 1;  
		dp[2] = 2;
		
		// DP 배열 채우기 - 점화식 
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		int cnt = 1;
		
		int beforeSeat = 0;
		
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(br.readLine());
			// vip 좌석을 제외한 나머지 좌석의 경우의 수를 서로 곱함
			cnt *= dp[temp - beforeSeat - 1];
			// vip 좌석 위치 
			beforeSeat = temp;
		}
		// 마지막 VIP 좌석 이후의 좌석 구간에 대한 배치 경우의 수를 곱함
		ans *= dp[N - beforeSeat]; // 마지막 vip 좌석 다음 좌석에서 끝 좌석까지의 경우의 수.

		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}

}
