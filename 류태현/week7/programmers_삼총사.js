function solution(number) {
  var answer = 0;

  function samchongsa(idx, cnt, sum) {
    if (cnt === 3 && sum === 0) {
      answer++;
      return;
    }
    if (idx === number.length) return;

    samchongsa(idx + 1, cnt + 1, sum + number[idx]);

    samchongsa(idx + 1, cnt, sum);
  }

  samchongsa(0, 0, 0);

  return answer;
}

function solution(s) {
  let cnt = 0;
  const s_arr = s.split("");

  for (let i = 0; i < s.length; i++) {
    if (cnt % 2 === 0) {
      //짝수고
      if (s_arr[i] != " ") {
        //공백이 아니면
        s_arr[i] = s_arr[i].toUpperCase(); //대문자로
        cnt++;
      }
    } else {
      //짝수가 아니면
      cnt = 0;
    }
  }

  return s_arr.join("");
}
