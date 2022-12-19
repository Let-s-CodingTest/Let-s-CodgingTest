def dfs(x, n, computers, checked):
    checked[x] = True #방문 처리

    for i in range(len(computers[x])): #한 컴퓨터의 연결 여부 확인
        if computers[x][i] == 1 and i != x: # 다른 컴퓨터와 연결이 되어있다면
            if not checked[i]: # 연결된 다른 컴퓨터가 check되지 않았다면
                dfs(i, n, computers, checked) # 재귀 호출

def solution(n, computers):
    answer = 0

    checked = [False] * (n+1)

    for i in range(n):
        if not checked[i]:
            dfs(i, n, computers, checked)
            answer+=1
    return answer