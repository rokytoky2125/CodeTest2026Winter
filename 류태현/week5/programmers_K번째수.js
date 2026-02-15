function solution(array, commands) {
  var answer = [];

  for (let z = 0; z < commands.length; z++) {
    const [i, j, k] = commands[z];
    let temp = [];
    temp = array.slice(i - 1, j).sort((a, b) => a - b);
    answer[z] = temp[k - 1];
  }

  return answer;
}
