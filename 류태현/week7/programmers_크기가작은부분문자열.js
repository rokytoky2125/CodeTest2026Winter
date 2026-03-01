function solution(t, p) {
  let answer = [];
  const len = p.length;
  let arr = [];
  const t_arr = t.split("");

  for (let i = 0; i < t.length - len + 1; i++) {
    arr.push(t_arr.slice(i, i + len).join(""));
  }

  arr = arr.map(Number);

  for (const num of arr) {
    if (num <= Number(p)) answer.push(num);
  }

  console.log(arr);

  return answer.length;
}
