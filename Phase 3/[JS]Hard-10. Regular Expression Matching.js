/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
const isMatch = (s, p) => {
  //패턴이랑 문자열이 둘다 비어있을경우 true
  if (!p) {
    return !s; //패턴은 없는데 문자열이 존재하면 false
  }
  //현재 위치의 패턴과 문자열 확인
  const checkMatch = Boolean(s) && (p[0] == s[0] || p[0] == ".");
  if (p[1] === "*") {
    //p[1]' * ' 다음 패턴이후 현재패턴이 넘어갈수있기때문에 다음 패턴까지 넘어갈수있다
    //그게 아니라면 현재 패턴과 매팅을 확인한후 다음 문자열을과 패턴을 매칭
    //현재위치에서 패턴이 매칭이 된다면 다음 문자열을 짤라서 재귀호출  패턴은 유지
    return isMatch(s, p.slice(2)) || (checkMatch && isMatch(s.slice(1), p));
  }
  //이후 * 이 아니라면 문자로 확인되고 다음 문자열과 다음 패턴으로 매칭을 확이하여 재귀, 여기서 매칭이 안되거나 아니면 문자열이 비어있으면 false
  return checkMatch ? isMatch(s.slice(1), p.slice(1)) : false;
};
