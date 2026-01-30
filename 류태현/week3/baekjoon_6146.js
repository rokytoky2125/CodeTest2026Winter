const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const [X, Y, N] = input[0];

const SIZE = 1001;
const map = Array.from({ length: SIZE }, () => Array(SIZE).fill(0));

for (let i = 1; i <= N; i++) {
  const [x, y] = input[i];
  map[y + 500][x + 500] = -1;
}

const dist = Array.from({ length: SIZE }, () => Array(SIZE).fill(-1));

const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

const targetX = X + 500;
const targetY = Y + 500;

function bfs(sx, sy) {
  if (map[sy][sx] === -1) return -1;

  const q = [];
  let head = 0;

  q.push([sy, sx]);
  dist[sy][sx] = 0;

  while (head < q.length) {
    const [y, x] = q[head++];

    if (x === targetX && y === targetY) return dist[y][x];

    for (let i = 0; i < 4; i++) {
      const nx = x + dx[i];
      const ny = y + dy[i];

      if (nx < 0 || ny < 0 || nx >= SIZE || ny >= SIZE) continue;
      if (map[ny][nx] === -1) continue;
      if (dist[ny][nx] !== -1) continue;

      dist[ny][nx] = dist[y][x] + 1;
      q.push([ny, nx]);
    }
  }

  return -1;
}
bfs(500, 500);
console.log(dist[targetY][targetX]);
