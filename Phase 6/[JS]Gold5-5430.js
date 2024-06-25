// https://www.acmicpc.net/problem/5430

const [T, ...input] = require("fs")
  .readFileSync("./input.txt")
  .toString()
  .trim()
  .split("\n");

let answer = [];
for (let i = 0; i < T; i++) {
  let p = input[3 * i];
  let n = parseInt(input[3 * i + 1]);
  let numArr = JSON.parse(input[3 * i + 2]);
  let startIdx = 0;
  let endIdx = n - 1;
  let isReversed = false;
  let errorOccurred = false;

  for (let x of p) {
    if (x == "R") {
      isReversed = !isReversed;
    } else {
      if (isReversed) {
        endIdx--;
      } else {
        startIdx++;
      }
      if (startIdx > endIdx + 1) {
        errorOccurred = true;
        break;
      }
    }
  }

  if (errorOccurred) {
    answer.push("error");
  } else {
    let resultArr = numArr.slice(startIdx, endIdx + 1);
    if (isReversed) {
      resultArr.reverse();
    }
    answer.push(`[${resultArr.join(",")}]`);
  }
}

console.log(answer.join("\n"));
