function solution(cards1, cards2, goal) {
  let result = "Yes";

  for (let i = 0; i < goal.length; i++) {
    const card1 = cards1.shift();
    const card2 = cards2.shift();
    if (goal[i] === card1) {
      cards2.unshift(card2);
      continue;
    }
    if (goal[i] === card2) {
      cards1.unshift(card1);
      continue;
    } else return "No";
  }
  return result;
}
