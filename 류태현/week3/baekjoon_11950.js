const fs = require("fs");

const lines = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const [N, M] = lines[0].split(" ").map(Number);
const flag = lines.slice(1).map((line) => line.trim().split(""));

let result = Infinity;

for (let i = 0; i < N - 2; i++) {
  for (let j = i + 1; j < N - 1; j++) {
    let sum = 0;

    for (let r = 0; r <= i; r++) {
      for (let c = 0; c < M; c++) {
        if (flag[r][c] !== "W") sum++;
      }
    }

    for (let r = i + 1; r <= j; r++) {
      for (let c = 0; c < M; c++) {
        if (flag[r][c] !== "B") sum++;
      }
    }

    for (let r = j + 1; r < N; r++) {
      for (let c = 0; c < M; c++) {
        if (flag[r][c] !== "R") sum++;
      }
    }

    if (sum < result) result = sum;
  }
}

console.log(result);
