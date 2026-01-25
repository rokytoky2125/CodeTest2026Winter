const input = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim()
  .split("\n")
  .map((el) => el.split(" ").map(Number));

const n = input[0][0];
const goal = input[0][1];

const arr = input[1];
q;
let count = 0;

const recursion = (i, sum) => {
  if (i === n) return;

  sum += arr[i];
  if (sum === goal) count++;

  recursion(i + 1, sum);
  recursion(i + 1, sum - arr[i]);
};

recursion(0, 0);
console.log(count);
