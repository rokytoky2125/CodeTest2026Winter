const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n");

const gears = [
  null,
  input[0].split(""),
  input[1].split(""),
  input[2].split(""),
  input[3].split(""),
];

const k = Number(input[4]);

function rotate(gear, dir) {
  if (dir === 1) {
    // 시계 방향
    const last = gear.pop();
    gear.unshift(last);
  } else {
    // 반시계 방향
    const first = gear.shift();
    gear.push(first);
  }
}

function processRotation(gearNum, dir, rotated) {
  if (rotated[gearNum]) return;

  rotated[gearNum] = true;

  if (gearNum > 1 && !rotated[gearNum - 1]) {
    if (gears[gearNum][6] !== gears[gearNum - 1][2]) {
      processRotation(gearNum - 1, -dir, rotated);
    }
  }

  if (gearNum < 4 && !rotated[gearNum + 1]) {
    if (gears[gearNum][2] !== gears[gearNum + 1][6]) {
      processRotation(gearNum + 1, -dir, rotated);
    }
  }

  rotate(gears[gearNum], dir);
}

for (let i = 0; i < k; i++) {
  const [gearNum, dir] = input[5 + i].split(" ").map(Number);

  const rotated = {};

  processRotation(gearNum, dir, rotated);
}

let score = 0;
if (gears[1][0] === "1") score += 1;
if (gears[2][0] === "1") score += 2;
if (gears[3][0] === "1") score += 4;
if (gears[4][0] === "1") score += 8;

console.log(score);
