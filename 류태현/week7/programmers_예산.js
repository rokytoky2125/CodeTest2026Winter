function solution(d, budget) {
  d.sort((a, b) => a - b);
  let sum = 0;
  let i = 0;
  for (i; i < d.length; i++) {
    sum += d[i];
    if (sum > budget) {
      break;
    }
  }

  return i;
}
