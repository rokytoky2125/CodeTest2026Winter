const fs = require("fs");

const lines = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((l) => l.trim());

let idx = 0;
const T = Number(lines[idx++]);

let out = [];

for (let tc = 0; tc < T; tc++) {
  const [R, C] = lines[idx++].split(" ").map(Number);

  const grid = [];
  for (let i = 0; i < R; i++) grid.push(lines[idx++].split(""));

  const visited = Array.from({ length: R }, () => Array(C).fill(false));

  const dx = [0, 1, 0, -1];
  const dy = [1, 0, -1, 0];

  function dfs(sy, sx) {
    const stack = [[sy, sx]];
    visited[sy][sx] = true;

    while (stack.length) {
      const [y, x] = stack.pop();

      for (let k = 0; k < 4; k++) {
        const ny = y + dy[k];
        const nx = x + dx[k];
        if (ny < 0 || nx < 0 || ny >= R || nx >= C) continue;
        if (visited[ny][nx]) continue;
        if (grid[ny][nx] !== "#") continue;

        visited[ny][nx] = true;
        stack.push([ny, nx]);
      }
    }
  }

  let count = 0;
  for (let i = 0; i < R; i++) {
    for (let j = 0; j < C; j++) {
      if (grid[i][j] === "#" && !visited[i][j]) {
        dfs(i, j);
        count++;
      }
    }
  }
  console.log(count);
}
