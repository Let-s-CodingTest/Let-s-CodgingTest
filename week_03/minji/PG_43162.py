def solution(n, computers):
    answer = 0
    visit = [0] * n
    for i in range(n):
        if visit[i] == 0:
            dfs(n, computers, visit, i)
            answer += 1

    return answer


def dfs(n, computers, visit, idx):
    visit[idx] = 1
    for i in range(n):
        if idx != i and computers[idx][i] == 1:
            if visit[i] == 0:
                dfs(n, computers, visit, i)