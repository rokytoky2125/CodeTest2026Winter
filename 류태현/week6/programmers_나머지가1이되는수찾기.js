function solution(n) {
  let answer = 1;
  while (true) {
    if (n % answer === 1) return answer;
    answer++;
  }
}
