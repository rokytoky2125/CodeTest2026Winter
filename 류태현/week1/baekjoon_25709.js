const input = +require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "./input.txt")
  .toString()
  .trim();

let count = 0;
let num = input;

while (num !== 0) {
  let num_arr = String(num).split("").map(Number);

  if (num_arr.includes(1)) {
    const idx = num_arr.indexOf(1);
    num_arr.splice(idx, 1);
    num = Number(num_arr.join(""));
    count++;
  } else {
    num--;
    count++;
  }
}

console.log(count);
