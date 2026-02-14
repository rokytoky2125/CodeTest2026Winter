function solution(needCoke, giveCoke, n) {
  var answer = 0;

  while (n >= needCoke) {
    const coke = Math.floor(n / needCoke) * giveCoke;
    answer += coke;
    n = coke + (n % needCoke); // coke = (20/3)*1 + 2 = 6 + 2 = 8
  }

  return answer;
}
