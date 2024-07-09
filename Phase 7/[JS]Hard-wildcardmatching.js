// 문제링크 : https://leetcode.com/problems/wildcard-matching/description/
// 문제레벨 : hard

/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
const isMatch = function (string, pattern) {
  let s = 0,
    p = 0;
  let starIdx = -1,
    pointer = -1;

  while (s < string.length) {
    //0 인덱스 부터 시작해서 패턴 이랑 문자열이 일치 하거나 ? 일경우  다음 인덱스
    if (string[s] === pattern[p] || pattern[p] === "?") {
      s++;
      p++;
    }
    //중간에 *이면  패턴 포인터만 다음으로 이동
    else if (pattern[p] === "*") {
      starIdx = p;
      pointer = s;
      p++;
    } else if (starIdx === -1) return false;
    else {
      //패턴과 매칭이 안될때 문자열 포인터만 이동
      p = starIdx + 1;
      pointer++;
      s = pointer;
    }
  }
  //문자열에 패턴에  끝나지 않았는데 남아있고 그 이후의 패턴이 * 이 아니라면 false
  for (let idx = p; idx < pattern.length; idx++) {
    if (pattern[idx] !== "*") return false;
  }
  return true;
};
