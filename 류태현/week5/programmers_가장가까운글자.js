function solution(s) {
  var answer = [];
  let idx = 0;
  answer[idx++] = -1;
  const str = s.trim("");
  for (let i = 1; i < str.length; i++) {
    answer[idx] = -1;
    for (let j = 0; j < i; j++) {
      if (str[i] === str[j]) {
        answer[idx] = i - j;
      }
    }
    idx++;
  }

  return answer;
}
