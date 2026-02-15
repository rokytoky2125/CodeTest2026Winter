function solution(sizes) {
  let maxW = 0;
  let maxH = 0;

  for (const [w, h] of sizes) {
    const big = Math.max(w, h);
    const small = Math.min(w, h);

    if (big > maxW) maxW = big;
    if (small > maxH) maxH = small;
  }

  return maxW * maxH;
}
