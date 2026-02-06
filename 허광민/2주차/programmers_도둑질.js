function solution(money) {
    const houseCount = money.length;
    
    // 첫 번째 집을 터는 경우 (마지막 집은 못 털음)
    const dpFirst = new Array(houseCount).fill(0);
    dpFirst[0] = money[0];
    dpFirst[1] = Math.max(money[0], money[1]);
    
    for (let idx = 2; idx < houseCount - 1; idx++) {
        dpFirst[idx] = Math.max(dpFirst[idx - 1], money[idx] + dpFirst[idx - 2]);
    }
    
    // 첫 번째 집을 안 터는 경우 (마지막 집 털 수 있음)
    const dpLast = new Array(houseCount).fill(0);
    dpLast[0] = 0;
    dpLast[1] = money[1];
    
    for (let idx = 2; idx < houseCount; idx++) {
        dpLast[idx] = Math.max(dpLast[idx - 1], money[idx] + dpLast[idx - 2]);
    }
    
    const maxFirst = Math.max(...dpFirst);
    const maxLast = Math.max(...dpLast);
    
    return Math.max(maxFirst, maxLast);
}
