const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const arr = input[1];
const start_idx = input[2][0] - 1;

function dfs(arr, start_idx) {
  const visited = new Array(arr.length).fill(false);
  const stack = [];

  stack.push(start_idx);

  while (stack.length) {
    const cur = stack.pop();

    if (visited[cur]) continue;
    visited[cur] = true;

    const jump = arr[cur];

    const left = cur - jump;
    const right = cur + jump;

    if (left >= 0 && left < arr.length && !visited[left]) {
      stack.push(left);
    }

    if (right >= 0 && right < arr.length && !visited[right]) {
      stack.push(right);
    }
  }

  let result = 0;
  for (const el of visited) {
    if (el) result++;
  }
  console.log(result);

  return visited;
}

dfs(arr, start_idx);
