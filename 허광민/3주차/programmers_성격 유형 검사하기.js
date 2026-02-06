function solution(survey, choices) {
    let answer = '';
    const typeScores = { "R": 0, "T": 0, "C": 0, "F": 0, "J": 0, "M": 0, "A": 0, "N": 0 };
    
    for (let idx = 0; idx < survey.length; idx++) {
        const item = survey[idx];
        const score = choices[idx];
        
        if (score > 4) {
            typeScores[item[1]] += score - 4;
        } else if (score < 4) {
            typeScores[item[0]] += 4 - score;
        }
    }
    
    const pairs = Object.entries(typeScores);
    
    for (let idx = 0; idx < 8; idx += 2) {
        if (pairs[idx][1] < pairs[idx + 1][1]) {
            answer += pairs[idx + 1][0];
        } else {
            answer += pairs[idx][0];
        }
    }
    
    return answer;
}
