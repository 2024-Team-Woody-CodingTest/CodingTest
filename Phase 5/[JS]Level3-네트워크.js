// 문제링크 : https://school.programmers.co.kr/learn/challenges?order=acceptance_asc&levels=2%2C3&languages=javascript
// 문제레벨 : Level 3
// 해결 방법: DFS (방문 체크 및 재귀)

function solution(n, computers) {
  let visited = [false];
  let answer = 0;

  function dfs(i) {
    //방문완료
    visited[i] = true;
    for (let j = 0; j < computers[i].length; j++) {
      //연결 되어있고 방문하지않았으면
      if (computers[i][j] === 1 && !visited[j]) {
        //방문 진행
        dfs(j);
      }
    }
  }
  for (let i = 0; i < computers.length; i++) {
    //방문하지 않았다면 네트워크 개수 증강
    if (!visited[i]) {
      dfs(i);
      answer++;
    }
  }
  return answer;
}
