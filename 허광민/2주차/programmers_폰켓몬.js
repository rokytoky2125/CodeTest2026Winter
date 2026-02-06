function solution(nums) {
    const uniqueCount = new Set(nums).size;
    const pickLimit = nums.length / 2;
    
    if (uniqueCount > pickLimit) {
        return pickLimit;
    }
    return uniqueCount;
}
