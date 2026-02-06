function solution(elements) {
    const sumSet = new Set();
    const totalLen = elements.length;
    
    for (let subLen = 1; subLen <= totalLen; subLen++) {
        for (let start = 0; start < totalLen; start++) {
            let partialSum = 0;
            
            for (let idx = 0; idx < subLen; idx++) {
                partialSum += elements[(start + idx) % totalLen];
            }
            
            sumSet.add(partialSum);
        }
    }
    
    return sumSet.size;
}
