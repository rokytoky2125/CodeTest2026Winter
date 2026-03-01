function solution(n, m) {
  var answer = [];

  if (m < n) [n, m] = [m, n];

  let n_arr1 = [];
  let m_arr1 = [];

  let m_arr2 = [];

  for (let i = 1; i <= n; i++) {
    if (n % i === 0) n_arr1.push(i);
  }

  for (let i = 1; i <= m; i++) {
    if (m % i === 0) m_arr1.push(i);
  }

  n_arr1.reverse();

  for (let i = 0; i < n_arr1.length; i++) {
    if (m_arr1.includes(n_arr1[i])) {
      answer.push(n_arr1[i]);
      break;
    }
  }

  for (let i = 1; i <= 1000000; i++) {
    m_arr2.push(m * i);
  }

  for (let i = 1; i < m_arr2.length; i++) {
    if (m_arr2.includes(n * i)) {
      answer.push(n * i);
      break;
    }
  }

  return answer;
}
