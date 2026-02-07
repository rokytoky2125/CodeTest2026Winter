function solution(food) {
  var answer = [];

  for (let i = food.length - 1; i > 0; i--) {
    if (food[i] % 2 === 0) {
      for (let j = 0; j < food[i] / 2; j++) {
        answer.push(i);
        answer.unshift(i);
      }
    } else {
      for (let j = 0; j < food[i] / 2 - 1; j++) {
        answer.push(i);
        answer.unshift(i);
      }
    }
  }

  const len = answer.length / 2;
  answer.splice(len, 0, 0);

  return answer.join("");
}
