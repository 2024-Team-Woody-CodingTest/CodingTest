function solution(want, number, discount) {
  var answer = 0;
  for (let i = 0; i < discount.length; i++) {
    //원하는 제품이 구매하게되면 증가한다
    if (buy(want, number, discount.slice(i, i + 10))) answer++;
  }
  return answer;
}
function buy(want, number, discount) {
  const map = new Map();
  //할인 하는 제품만큰 반복
  //할인하는 제품별 개수를 저장
  for (let i = 0; i < discount.length; i++) {
    map.has(discount[i])
      ? map.set(discount[i], map.get(discount[i]) + 1)
      : map.set(discount[i], 1);
  }
  //구매를 원하는 want
  for (let i = 0; i < want.length; i++) {
    //할인제품에 원하는개 없다면 false
    if (isNaN(map.get(want[i]))) return false;
    //구매를원하는 제품보다 할인하는 제품의 개수가적다면 false
    if (number[i] > map.get(want[i])) return false;
  }
  //원하는 만큼 구매 가능
  return true;
}
