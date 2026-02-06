const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" "));

const resultSet = new Set();

const dx = [0, 1, 0, -1];
const dy = [1, 0, -1, 0];

function dfs(y, x, number) {
  if (number.length === 6) {
    resultSet.add(number);
    return;
  }

  for (let i = 0; i < 4; i++) {
    const nx = x + dx[i];
    const ny = y + dy[i];

    if (nx < 0 || ny < 0 || nx >= 5 || ny >= 5) continue;

    dfs(ny, nx, number + input[ny][nx]);
  }
}

for (let i = 0; i < 5; i++) {
  for (let j = 0; j < 5; j++) {
    dfs(i, j, input[i][j]);
  }
}

console.log(resultSet.size);
