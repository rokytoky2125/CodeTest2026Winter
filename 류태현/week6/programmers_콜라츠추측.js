function solution(num) {
  function col(n, cnt) {
    if (n === 1) return cnt;
    if (cnt === 500) return -1;

    if (n % 2 === 0) return col(n / 2, cnt + 1);
    return col(n * 3 + 1, cnt + 1);
  }

  return col(num, 0);
}
