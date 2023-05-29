from itertools import permutations


def check(users, banned_id):
    for i in range(len(users)) :
        if len(users[i])!=len(banned_id[i]) :
            return False

        for j in range(len(users[i])) :
            if banned_id[i][j]!='*' and banned_id[i][j]!=users[i][j] :
                return False
    return True


def solution(user_id, banned_id):
    answer = set()

    user_permutations = permutations(user_id, len(banned_id))

    for users in user_permutations:
        if check(users, banned_id) :
            users = tuple(set(users))
            answer.add(users)
    return len(answer)

print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "abc1**"]))