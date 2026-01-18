function solution(text, excluded, shift) {
    const base = "abcdefghijklmnopqrstuvwxyz";
    const usable = [...base].filter(ch => !excluded.includes(ch));

    let result = "";

    for (const ch of text) {
        const pos = usable.indexOf(ch);
        const next = (pos + shift) % usable.length;
        result += usable[next];
    }

    return result;
}
