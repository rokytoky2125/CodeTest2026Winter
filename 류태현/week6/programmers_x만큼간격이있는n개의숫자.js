function solution(x, n) {
  var answer = [];
  let cur = x;
  for (let i = 0; i < n; i++) {
    answer[i] = cur;
    cur += x;
  }
  return answer;
}
