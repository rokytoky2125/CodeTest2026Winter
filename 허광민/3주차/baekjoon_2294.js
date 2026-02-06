const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [coinCount, targetValue] = input[0].split(' ').map(Number);
const coins = [];

for (let idx = 1; idx <= coinCount; idx++) {
    coins.push(parseInt(input[idx]));
}

const dp = new Array(targetValue + 1).fill(100001);
dp[0] = 0;

for (const coin of coins) {
    for (let val = coin; val <= targetValue; val++) {
        dp[val] = Math.min(dp[val], dp[val - coin] + 1);
    }
}

if (dp[targetValue] === 100001) {
    console.log(-1);
} else {
    console.log(dp[targetValue]);
}
