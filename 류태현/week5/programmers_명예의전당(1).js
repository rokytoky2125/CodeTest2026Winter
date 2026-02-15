function solution(k, score) {
  var answer = [];

  for (let i = 0; i < score.length; i++) {
    let temp = score.slice(0, i + 1).sort((a, b) => b - a);
    if (temp.length < k) answer.push(temp[temp.length - 1]);
    else answer.push(temp[k - 1]);
  }

  return answer;
}
