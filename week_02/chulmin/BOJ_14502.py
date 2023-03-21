import copy
from collections import deque

def bfs():
    queue = deque()
    graph = copy.deepcopy(lab)
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 2:
                queue.append((i, j))

    while queue:
        x, y = queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            if graph[nx][ny] == 0:
                graph[nx][ny] = 2
                queue.append((nx, ny))

    global answer
    cnt = 0

    for i in range(n):
        cnt += graph[i].count(0)

    answer = max(answer, cnt)

# 1. 벽 설치
def getWall(wall):
    # 재귀 종료 조건 -> 벽 다 쌓고 bfs() 최대값 찾기 위해 호출
    if wall == 3:
        bfs()
        return

    for i in range(n):
        for j in range(m):
            if lab[i][j] == 0:
                lab[i][j] = 1
                getWall(wall + 1)
                lab[i][j] = 0


n, m = map(int, input().split())
lab = []

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

for i in range(n):
    lab.append(list(map(int, input().split())))

result = 0
getWall(0)
print(result)
