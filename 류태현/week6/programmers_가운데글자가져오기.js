function solution(s) {
  return s.length % 2 !== 0
    ? s[Math.round(s.length / 2) - 1]
    : s[s.length / 2 - 1] + s[s.length / 2];
}
