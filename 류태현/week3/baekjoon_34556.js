const fs = require("fs");

const lines = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((s) => s.trim());

const N = Number(lines[0]);

const men = lines.slice(1, 1 + N);
const women = lines.slice(1 + N, 1 + 2 * N);

const sum_map = Array.from({ length: N }, () => Array(N).fill(0));

function sumMbti(a, b) {
  let sum = 0;
  for (let i = 0; i < 4; i++) {
    if (a[i] !== b[i]) sum++;
  }
  return sum;
}

for (let i = 0; i < men.length; i++) {
  for (let j = 0; j < women.length; j++) {
    sum_map[i][j] = sumMbti(men[i], women[j]);
  }
}

let best = 0;
const used = Array(N).fill(false);

function backtrack(i, sum) {
  if (i === N) {
    if (sum > best) best = sum;
    return;
  }

  for (let j = 0; j < N; j++) {
    if (used[j]) continue;

    used[j] = true;
    backtrack(i + 1, sum + sum_map[i][j]);
    used[j] = false;
  }
  q;
}

backtrack(0, 0);
console.log(best);
