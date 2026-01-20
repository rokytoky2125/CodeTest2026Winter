const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split("").map(Number));

const map = input.slice(1);

let start = [];

for (let i = 0; i < map[0].length; i++) {
  if (map[0][i] === 0) start.push(i);
}

function dfs(map, start) {
  const R = map.length;
  const C = map[0].length;

  const visited = Array.from({ length: R }, () => Array(C).fill(false));

  const stack = [];
  for (const el of start) {
    stack.push([0, el]);
  }

  const dx = [0, 1, 0, -1];
  const dy = [1, 0, -1, 0];

  while (stack.length) {
    const [y, x] = stack.pop();

    if (visited[y][x]) continue;
    visited[y][x] = true;

    for (let i = 0; i < 4; i++) {
      const ny = y + dy[i];
      const nx = x + dx[i];

      if (nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
      if (visited[ny][nx]) continue;
      if (map[ny][nx] !== 0) continue;

      stack.push([ny, nx]);
    }
  }
  if (visited[R - 1].includes(true)) {
    console.log("YES");
  } else {
    console.log("NO");
  }
}

dfs(map, start);
