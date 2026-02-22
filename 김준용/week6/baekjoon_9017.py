import sys
filed = sys.stdin.read().splitlines()

for lines in range(2,len(filed),2):
    freq = {}
    runners = filed[lines].split()
    for c in runners:
        freq[c] = freq.get(c, 0) + 1

    valid = {team for team, count in freq.items() if count >= 6}
    fifth={}
    scores={}
    tallies={}
    smallest_num = 10**9
    smallest_team = ['a']
    i=1
    for runner in runners:
        if runner not in valid:
            continue
        tally = tallies.get(runner, 0) + 1
        tallies[runner] = tally
        if tally < 5:
            scores[runner] = scores.get(runner, 0) + i
        elif tally == 5:
            fifth[runner] = i
            if scores[runner] < smallest_num:
                smallest_num = scores[runner]
                smallest_team = [runner]
            elif scores[runner] == smallest_num:
                smallest_team.append(runner)
        i+=1
    if len(smallest_team)==1:
        print(*smallest_team)
    else:
        smallest_num=10**9
        final = ''
        for j in smallest_team:
                if fifth[j] < smallest_num:
                    final = j
                    smallest_num = fifth[j]
        print(final)
