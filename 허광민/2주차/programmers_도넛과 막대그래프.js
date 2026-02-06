function solution(edges) {
    function countEdges(edges) {
        const edgeCounts = {};
        
        for (const [from, to] of edges) {
            if (!edgeCounts[from]) {
                edgeCounts[from] = [0, 0];
            }
            if (!edgeCounts[to]) {
                edgeCounts[to] = [0, 0];
            }
            
            edgeCounts[from][0] += 1;  // 나가는거
            edgeCounts[to][1] += 1;    // 들어오는거
        }
        return edgeCounts;
    }
    
    function checkAnswer(edgeCounts) {
        const answer = [0, 0, 0, 0];
        
        for (const [node, counts] of Object.entries(edgeCounts)) {
            const outCount = counts[0];
            const inCount = counts[1];
            
            if (outCount >= 2 && inCount === 0) {
                answer[0] = parseInt(node);
            }
            else if (outCount === 0 && inCount > 0) {
                answer[2] += 1;
            }
            else if (outCount >= 2 && inCount >= 2) {
                answer[3] += 1;
            }
        }
        
        answer[1] = edgeCounts[answer[0]][0] - answer[2] - answer[3];
        return answer;
    }
    
    const edgeCounts = countEdges(edges);
    const answer = checkAnswer(edgeCounts);
    
    return answer;
}
