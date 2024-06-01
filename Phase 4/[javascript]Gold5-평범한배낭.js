// GOLD5 - (https://www.acmicpc.net/problem/12865)
// DP

/*
  dp문제로 세로열은 물건의 갯수 가로열은 무게로 2차원배열을 만들어서 풀이해야함.
*/

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const input = fs.readFileSync(filePath).toString().trim().split('\n');

let [N, K] = input
  .shift()
  .split(' ')
  .map((item) => +item);

const item = input.map((item) => item.split(' '));

const dp = Array.from(Array(N + 1), () => new Array(K + 1).fill(0));

// 물건 수 만큼 1차 for문 진행
for (let i = 1; i < N + 1; i++) {
  const [W, V] = item[i - 1].map((item) => +item);
  // 무게 만큼 2차 for문 진행, 각 무게별로 들어갈 수 있는 물건을 구하기 위해서
  for (let j = 1; j <= K; j++) {
    //만약 현재 물건의 무게가 가방의 무게보다 작다면 넣을 수 있기때문에 새로운 값을 계산해볼 기회가 생긴다.
    // dp[x][y] , x는 물건의 갯수 | y는 가방의 무게
    // 해당 물건을 안넣으니 x는 i -1 이고 그 안넣은 상태에서 해당 물건을 넣게 되면 무게가 증가하니 그만큼 뺴준 y는 j - W 이고 거기에 현재 물건의 가치를 더한다.
    // dp[i - 1][j]는 물건을 넣지 못할 때 그 전의 무게중 가장 큰 i-1번째 가치와 동일시함
    if (j - W >= 0) dp[i][j] = Math.max(dp[i - 1][j - W] + V, dp[i - 1][j]);
    else dp[i][j] = dp[i - 1][j];
  }
}

console.log(dp[N][K]);
