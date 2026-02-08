function solution(n, money) {
  const dp = [1, ...Array(n).fill(0)];

  for (const m of money) {
    for (let i = m; i <= n; i++) {
      dp[i] = (dp[i] + dp[i - m]) % 1000000007;
    }
  }

  return dp[n] % 1000000007;
}
