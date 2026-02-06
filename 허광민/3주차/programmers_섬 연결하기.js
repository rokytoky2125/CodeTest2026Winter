function getRoot(parent, node) {
    if (parent[node] === node) return node;
    return getRoot(parent, parent[node]);
}

function mergeNodes(parent, nodeA, nodeB) {
    const rootA = getRoot(parent, nodeA);
    const rootB = getRoot(parent, nodeB);
    
    if (rootA < rootB) {
        parent[rootB] = rootA;
    } else {
        parent[rootA] = rootB;
    }
}

function isSameGroup(parent, nodeA, nodeB) {
    const rootA = getRoot(parent, nodeA);
    const rootB = getRoot(parent, nodeB);
    
    return rootA === rootB;
}

function solution(n, costs) {
    const parent = new Array(n).fill(0).map((_, idx) => idx);
    
    let totalCost = 0;
    
    costs.sort((a, b) => a[2] - b[2]);
    
    for (const [nodeA, nodeB, cost] of costs) {
        if (!isSameGroup(parent, nodeA, nodeB)) {
            mergeNodes(parent, nodeA, nodeB);
            totalCost += cost;
        }
    }
    
    return totalCost;
}
