// leetcode - medium  [Rotting Oranges - LeetCode](https://leetcode.com/problems/rotting-oranges/description/?envType=study-plan-v2&envId=leetcode-75)
// BFS

/*
  문제 : 썩은 오렌지가 주변 신선한 오렌지를 썩게하는 시간을 구하는 문제

  문제점  :
    1. 썩은 오렌지가 모두 감염시켰을 때 바로 판단할 수 있는 방법이 필요함
      모두 감염됐는지 어떻게 판단해야하나?
    ⇒ queue에 썩은 오렌지가 없을 때까지 진행
    
    2. 썩은 오렌지가 두개 이상일 경우 어떻게 해야할지 
    ⇒ 이건 2인 좌표를 한번에 queue에 담아서 처리
*/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var orangesRotting = function (grid) {
  let m = grid.length;
  let n = grid[0].length;
  let visited = Array.from(Array(m), () => new Array(n).fill(false));

  // 상하좌우 탐색을 위한 상수 배열
  const dx = [-1, 1, 0, 0];
  const dy = [0, 0, -1, 1];

  let queue = [];

  let answer = 0;

  // 2, 즉 썩은 오렌지의 좌표를 미리 queue에 담기
  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 2) {
        visited[i][j] = true;
        queue.push([i, j, 0]);
      }
    }
  }

  // bfs를 이용해서 확인하기
  // 해당 예시 처럼 뻗어나가는 경우의 수가 많을 경우 cost가 제대로 측정되지않았음.
  // 따라서 queue에 좌표를 관리하면서 cost까지 같이 관리해야 제대로 cost를 측정할 수 있다.
  while (queue.length !== 0) {
    let [x, y, time] = queue.shift();

    for (let i = 0; i < 4; i++) {
      let X = x + dx[i];
      let Y = y + dy[i];
      if (
        X >= 0 &&
        X < m &&
        Y >= 0 &&
        Y < n &&
        !visited[X][Y] &&
        grid[X][Y] === 1
      ) {
        // queue에 현재의 cost를 담고 있어야한다.
        grid[X][Y] = 2;
        queue.push([X, Y, cost + 1]);
        visited[X][Y] = true;
      }
    }

    answer = cost;
  }

  for (let i = 0; i < m; i++) {
    for (let j = 0; j < n; j++) {
      if (grid[i][j] === 1) {
        return -1;
      }
    }
  }

  return answer;
};
