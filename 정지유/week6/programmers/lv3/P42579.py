def solution(genres, plays):
    total = {}
    songs = {}

    for i, (g, p) in enumerate(zip(genres, plays)):
        total[g] = total.get(g, 0) + p
        songs.setdefault(g, []).append((p, i))

    genre_order = sorted(total.keys(), key=lambda g: total[g], reverse=True)

    answer = []
    for g in genre_order:
        top = sorted(songs[g], key=lambda x: (-x[0], x[1]))[:2]
        answer.extend(i for _, i in top)

    return answer