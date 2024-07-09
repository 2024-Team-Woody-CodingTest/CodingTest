// https://www.acmicpc.net/problem/2167

const fs = require("fs");

const input = fs.readFileSync("./input.txt").toString().trim().split("\n");
const [N, M] = input[0].split(" ").map(Number);

let arr = [];
for (let i = 1; i <= N; i++) {
  arr.push(input[i].split(" ").map(Number));
}

const K = parseInt(input[N + 1]);
let queries = [];
for (let i = N + 2; i < N + 2 + K; i++) {
  queries.push(input[i].split(" ").map(Number));
}

let dp = Array.from({ length: N + 1 }, () => Array(M + 1).fill(0));

for (let i = 1; i <= N; i++) {
  for (let j = 1; j <= M; j++) {
    dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + arr[i - 1][j - 1] - dp[i - 1][j - 1];
  }
}

let results = [];
queries.forEach(([i, j, x, y]) => {
  let sum = dp[x][y] - dp[x][j - 1] - dp[i - 1][y] + dp[i - 1][j - 1];
  results.push(sum);
});

console.log(results.join("\n"));
