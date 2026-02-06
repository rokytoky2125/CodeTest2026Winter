function solution(str, shift) {
    const chars = str.split('');
    
    for (let idx = 0; idx < chars.length; idx++) {
        const char = chars[idx];
        
        if (char >= 'A' && char <= 'Z') {
            const code = (char.charCodeAt(0) - 'A'.charCodeAt(0) + shift) % 26;
            chars[idx] = String.fromCharCode(code + 'A'.charCodeAt(0));
        } else if (char >= 'a' && char <= 'z') {
            const code = (char.charCodeAt(0) - 'a'.charCodeAt(0) + shift) % 26;
            chars[idx] = String.fromCharCode(code + 'a'.charCodeAt(0));
        }
    }
    
    return chars.join('');
}
