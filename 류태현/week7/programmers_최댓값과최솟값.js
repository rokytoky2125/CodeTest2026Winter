function solution(s) {
  let arr = s
    .split(" ")
    .map(Number)
    .sort((a, b) => a - b);
  const min = String(arr[0]);
  const max = String(arr[arr.length - 1]);
  return `${min} ${max}`;
}
