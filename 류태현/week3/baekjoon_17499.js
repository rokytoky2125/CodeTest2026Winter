const fs = require("fs");

const input = fs
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((line) => line.split(" ").map(Number));

const N = input[0][0];
const Q = input[0][1];

const arr = input[1];
let offset = 0;
for (let i = 2; i < 2 + Q; i++) {
  const type = input[i][0];

  if (type === 1) {
    const idx = input[i][1];
    const x = input[i][2];

    const real = (offset + (idx - 1)) % N;
    arr[real] += x;
  } else if (type === 2) {
    const s = input[i][1];

    offset = (offset - s) % N;
    if (offset < 0) offset += N;
  } else {
    const s = input[i][1];

    offset = (offset + s) % N;
  }
}

let out = new Array(N);
for (let i = 0; i < N; i++) {
  out[i] = arr[(offset + i) % N];
}
process.stdout.write(out.join(" "));
