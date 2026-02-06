function solution(board) {
    const rowCount = board.length;
    const colCount = board[0].length;
    
    // DP로 각 위치에서 만들 수 있는 최대 정사각형 변 길이 계산해준다
    for (let row = 1; row < rowCount; row++) {
        for (let col = 1; col < colCount; col++) {
            if (board[row][col] === 1) {
                board[row][col] = Math.min(
                    board[row - 1][col - 1],
                    board[row - 1][col],
                    board[row][col - 1]
                ) + 1;
            }
        }
    }
    
    // 최대 변 길이를 찾아준다
    let maxSide = 0;
    for (let row = 0; row < rowCount; row++) {
        const rowMax = Math.max(...board[row]);
        maxSide = Math.max(maxSide, rowMax);
    }
    
    return maxSide ** 2;
}
