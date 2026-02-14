function solution(line) {
  const pos = [];
  const answer = [];
  const n = line.length;

  let x_min = 1e15;
  let y_min = 1e15;
  let x_max = -1e15;
  let y_max = -1e15;

  for (let i = 0; i < n; i++) {
    const [a, b, e] = line[i];
    for (let j = i + 1; j < n; j++) {
      const [c, d, f] = line[j];
      if (a * d === b * c) continue;
      const x = (b * f - e * d) / (a * d - b * c);
      const y = (e * c - a * f) / (a * d - b * c);

      if (Number.isInteger(x) && Number.isInteger(y)) {
        const ix = Math.trunc(x);
        const iy = Math.trunc(y);
        pos.push([ix, iy]);
        x_min = Math.min(x_min, ix);
        y_min = Math.min(y_min, iy);
        x_max = Math.max(x_max, ix);
        y_max = Math.max(y_max, iy);
      }
    }
  }

  const x_len = x_max - x_min + 1;
  const y_len = y_max - y_min + 1;
  const coord = Array.from({ length: y_len }, () => Array(x_len).fill('.'));

  for (const [star_x, star_y] of pos) {
    const nx = x_min < 0 ? star_x + Math.abs(x_min) : star_x - x_min;
    const ny = y_min < 0 ? star_y + Math.abs(y_min) : star_y - y_min;
    coord[ny][nx] = '*';
  }

  for (const result of coord) {
    answer.push(result.join(''));
  }

  return answer.reverse();
}
