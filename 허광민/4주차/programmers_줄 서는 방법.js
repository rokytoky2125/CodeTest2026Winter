function factorial(n) {
  if (n <= 1) return 1;
  return n * factorial(n - 1);
}

function solution(n, k) {
  const answer = [];
  const people = Array.from({ length: n }, (_, i) => i + 1);

  for (let i = 1; i <= n; i++) {
    const divider = factorial(n - i);
    let idx = Math.floor(k / divider);
    if (k % divider === 0) {
      idx -= 1;
    }

    answer.push(people[idx]);
    people.splice(idx, 1);
    k -= idx * divider;
  }

  return answer;
}
