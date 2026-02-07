function solution(s, n) {
  var answer = "";

  const line = s.split("");

  for (let i = 0; i < line.length; i++) {
    if (line[i] !== " ") {
      if (
        line[i].charCodeAt(0) <= "z".charCodeAt(0) &&
        line[i].charCodeAt(0) >= "a".charCodeAt(0)
      ) {
        const shift =
          "a".charCodeAt(0) +
          ((line[i].charCodeAt(0) - "a".charCodeAt(0) + n) % 26);
        answer += String.fromCharCode(shift);
      } else {
        const shift =
          "A".charCodeAt(0) +
          ((line[i].charCodeAt(0) - "A".charCodeAt(0) + n) % 26);
        answer += String.fromCharCode(shift);
      }
    } else answer += " ";
  }

  return answer;
}
