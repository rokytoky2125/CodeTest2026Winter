const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim();

const num = parseInt(input);
const dp = new Array(31).fill(0);
dp[2] = 3;

for (let idx = 4; idx <= num; idx++) {
    if (idx % 2 === 0) {
        let prevSum = 0;
        for (let j = 0; j < idx - 2; j++) {
            prevSum += dp[j];
        }
        dp[idx] = dp[idx - 2] * 3 + prevSum * 2 + 2;
    } else {
        dp[idx] = 0;
    }
}

console.log(dp[num]);
