function solution(lottos, win_nums) {
  const rank = [6, 6, 5, 4, 3, 2, 1];

  const cnt_0 = lottos.filter((x) => x === 0).length;
  let ans = 0;
  for (const x of win_nums) {
    if (lottos.includes(x)) ans += 1;
  }
  return [rank[cnt_0 + ans], rank[ans]];
}
