// Medium - (https://leetcode.com/problems/container-with-most-water/description/?envType=study-plan-v2&envId=leetcode-75)
// 투포인터

/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
  let start = 0;
  let end = height.length - 1;

  let currentMax = -1;

  while (start < end) {
    let newMax = (end - start) * Math.min(height[start], height[end]); // 넓이
    if (newMax >= currentMax) {
      currentMax = newMax;
    }
    if (height[start] >= height[end]) {
      end--;
    } else {
      start++;
    }
  }

  return currentMax;
};
