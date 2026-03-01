function solution(nums) {
  const ponketmon = [...new Set(nums)];

  return ponketmon.length < nums.length / 2
    ? ponketmon.length
    : nums.length / 2;
}
