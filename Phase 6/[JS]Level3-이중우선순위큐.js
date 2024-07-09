//https://school.programmers.co.kr/learn/courses/30/lessons/42628
// 문제레벨 : Level 3
// 간단한 조건문

function solution(operations) {
  var answer = [];
  for (let i in operations) {
    //연산자와 값나누기
    let element = operations[i].split(" ");
    //삽입
    if (element[0] == "I") {
      answer.push(parseInt(element[1]));
    }
    //제거
    else if (element[0] == "D") {
      //최소값 제거
      if (element[1] == "-1") {
        let min = Math.min(...answer);
        answer = answer.filter((item) => item !== min);
      }
      //최대값 제거
      else {
        let max = Math.max(...answer);
        answer = answer.filter((item) => item !== max);
      }
    }
  }
  if (answer.length == 0) {
    return [0, 0];
  } else {
    return [Math.max(...answer), Math.min(...answer)];
  }
}
