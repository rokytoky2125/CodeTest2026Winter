function solution(n, s, a, b, fares) {
  const INF = Number.MAX_SAFE_INTEGER;

  // 인접리스트
  const maps = Array.from({ length: n + 1 }, () => []);
  for (const [v, u, c] of fares) {
    maps[v].push([u, c]);
    maps[u].push([v, c]);
  }

  function dijkstra(start) {
    const distance = Array(n + 1).fill(INF);
    distance[start] = 0;
    const que = [[0, start]];

    while (que.length > 0) {
      que.sort((a, b) => a[0] - b[0]);
      const [cur_dist, cur_node] = que.shift();

      if (distance[cur_node] < cur_dist) continue;

      for (const [next_node, next_dist] of maps[cur_node]) {
        const newDist = cur_dist + next_dist;
        if (distance[next_node] > newDist) {
          distance[next_node] = newDist;
          que.push([newDist, next_node]);
        }
      }
    }
    return distance;
  }

  const D = [null];
  for (let i = 1; i <= n; i++) {
    D.push(dijkstra(i));
  }

  let path = INF;
  for (let i = 1; i <= n; i++) {
    path = Math.min(path, D[s][i] + D[i][a] + D[i][b]);
  }

  return path;
}
