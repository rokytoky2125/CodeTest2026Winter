function solution(name, yearning, photo) {
  var answer = [];
  let map = new Map();

  for (let i = 0; i < name.length; i++) {
    map.set(name[i], yearning[i]);
  }

  for (let i = 0; i < photo.length; i++) {
    let result = 0;
    for (let j = 0; j < photo[i].length; j++) {
      if (name.includes(photo[i][j])) {
        result += map.get(photo[i][j]);
      }
    }
    answer.push(result);
  }

  return answer;
}
