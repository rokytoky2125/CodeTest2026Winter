function solution(rows, columns, queries) {
  const answer = [];
  const array = Array.from({ length: rows }, () => Array(columns).fill(0));
  let t = 1;
  for (let row = 0; row < rows; row++) {
    for (let col = 0; col < columns; col++) {
      array[row][col] = t;
      t += 1;
    }
  }

  for (const [x1, y1, x2, y2] of queries) {
    let tmp = array[x1 - 1][y1 - 1];
    let mini = tmp;

    for (let k = x1 - 1; k < x2 - 1; k++) {
      const test = array[k + 1][y1 - 1];
      array[k][y1 - 1] = test;
      mini = Math.min(mini, test);
    }

    for (let k = y1 - 1; k < y2 - 1; k++) {
      const test = array[x2 - 1][k + 1];
      array[x2 - 1][k] = test;
      mini = Math.min(mini, test);
    }

    for (let k = x2 - 1; k > x1 - 1; k--) {
      const test = array[k - 1][y2 - 1];
      array[k][y2 - 1] = test;
      mini = Math.min(mini, test);
    }

    for (let k = y2 - 1; k > y1 - 1; k--) {
      const test = array[x1 - 1][k - 1];
      array[x1 - 1][k] = test;
      mini = Math.min(mini, test);
    }

    array[x1 - 1][y1] = tmp;
    answer.push(mini);
  }

  return answer;
}
