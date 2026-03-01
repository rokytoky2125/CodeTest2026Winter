function solution(s) {
  let cnt = 0;
  const s_arr = s.split("");

  for (let i = 0; i < s.length; i++) {
    if (s_arr[i] === " ") {
      cnt = 0;
      continue;
    }
    if (cnt % 2 === 0) s_arr[i] = s_arr[i].toUpperCase();
    else s_arr[i] = s_arr[i].toLowerCase();
    cnt++;
  }

  return s_arr.join("");
}
