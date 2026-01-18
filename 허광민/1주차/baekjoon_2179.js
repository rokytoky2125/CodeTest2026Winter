const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [rows, cols] = input[0].split(' ').map(Number);
const grid = [];
for (let i = 1; i <= rows; i++) {
    grid.push(input[i].split('').map(Number));
}

function bfs(grid, startRow, startCol) {
    const queue = [];
    queue.push([startRow, startCol]);
    
    while (queue.length > 0) {
        const [currentRow, currentCol] = queue.shift();
        const rowOffsets = [0, 0, 1, -1];
        const colOffsets = [1, -1, 0, 0];
        
        for (let dir = 0; dir < 4; dir++) {
            const nextRow = currentRow + rowOffsets[dir];
            const nextCol = currentCol + colOffsets[dir];
            
            if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols) {
                continue;
            }
            
            if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols && grid[nextRow][nextCol] === 1) {
                grid[nextRow][nextCol] = grid[currentRow][currentCol] + 1;
                queue.push([nextRow, nextCol]);
            }
        }
    }
    
    return grid[rows - 1][cols - 1];
}

console.log(bfs(grid, 0, 0));
