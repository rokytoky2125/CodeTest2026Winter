function solution(n, arr1, arr2) {
  const answer = Array.from({ length: n }, () => Array(n).fill(" "));
  let num1 = [];
  let num2 = [];

  function changeToBinary(num) {
    let arr = [];
    while (num !== 0) {
      arr.unshift(num % 2);
      num = Math.floor(num / 2);
    }

    while (arr.length !== n) arr.unshift(0);

    return arr;
  }

  for (let i = 0; i < n; i++) {
    num1.push(changeToBinary(arr1[i]));
    num2.push(changeToBinary(arr2[i]));
    for (let j = 0; j < n; j++) {
      if (num1[i][j] || num2[i][j] === 1) answer[i][j] = "#";
    }
    answer[i] = answer[i].join("");
  }

  return answer;
}
