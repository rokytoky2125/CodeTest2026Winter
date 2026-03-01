function solution(number, limit, power) {
  var answer = 0;

  function getFactor(knight) {
    let factor = 0;
    let cnt = 1;

    while (cnt <= Math.sqrt(knight)) {
      if (knight % cnt === 0) {
        if (cnt * cnt === knight) factor += 1;
        else factor += 2;
      }
      cnt++;
    }
    return factor;
  }

  for (let i = 1; i <= number; i++) {
    const result = getFactor(i);
    if (result > limit) answer += power;
    else answer += result;
  }

  return answer;
}
