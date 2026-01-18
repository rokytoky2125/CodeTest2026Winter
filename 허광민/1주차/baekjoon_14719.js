const input = require('fs')
  .readFileSync(process.platform === 'linux' ? '/dev/stdin' : './input.txt')
  .toString()
  .trim()
  .split(/\s+/)
  .map(Number);

let idx = 0;
const H = input[idx++];
const W = input[idx++];

const heights = [];
for (let i = 0; i < W; i++) {
  heights.push(input[idx++]);
}

let answer = 0;

for (let i = 1; i < W - 1; i++) {
  let leftMax = 0;
  let rightMax = 0;

  for (let j = 0; j < i; j++) {
    leftMax = Math.max(leftMax, heights[j]);
  }

  for (let j = i + 1; j < W; j++) {
    rightMax = Math.max(rightMax, heights[j]);
  }

  const water = Math.min(leftMax, rightMax) - heights[i];
  if (water > 0) {
    answer += water;
  }
}

console.log(answer);
