// GOLD5 - (https://www.acmicpc.net/problem/15486)
// DP

const fs = require('fs');
const filePath = process.platform === 'linux' ? '/dev/stdin' : './input.txt';
const [n, ...arr] = fs.readFileSync(filePath).toString().trim().split('\n');

const N = Number(n);
const board = arr.map((item) => item.split(' ').map(Number));

const dp = Array.from(Array(N + 1).fill(0));

let max = 0;

// 1일차 부터 차례대로 순회하면서 계산해야함.
for (let i = 0; i < N; i++) {
  // 해당 일짜에 들어온 일의 소요 날짜와 페이가 들어온다.
  let [day, money] = board[i];

  // max는 i(즉, 현재 며칠째에 대해 지금까지의 최대 값을 의미한다.)
  max = Math.max(max, dp[i]);

  // dp에는 현재 최대값 + 이번에 할일에 대한 페이 와 지금까지 진행되었던 페이를 비교해서 더 큰 것으로 대체한다.
  if (i + day <= N) {
    dp[i + day] = Math.max(dp[i + day], max + money);
  }
}

console.log(Math.max(...dp));
