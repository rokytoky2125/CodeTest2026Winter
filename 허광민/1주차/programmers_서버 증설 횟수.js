function solution(loads, unit, duration) {
    const active = new Array(24).fill(0);
    let total = 0;

    for (let hour = 0; hour < loads.length; hour++) {
        const users = loads[hour];
        const required = Math.floor(users / unit);

        if (required <= active[hour]) continue;

        const add = required - active[hour];

        for (let t = hour; t < hour + duration && t < 24; t++) {
            active[t] += add;
        }

        total += add;
    }

    return total;
}
