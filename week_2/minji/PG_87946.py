from itertools import permutations


def solution(k, dungeons):
    answer = 0
    dungeon_permutations = permutations(dungeons)
    for dungeon in dungeon_permutations:
        tmp = k
        count = 0
        for d in dungeon:
            if tmp >= d[0] and tmp >= d[1]:
                tmp -= d[1]
                count += 1
        answer = max(answer, count)
    return answer