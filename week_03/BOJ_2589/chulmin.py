from collections import deque
import sys
input = sys.stdin.readline

n,m = map(int, input().split())
graph = []

#그래프 입력
for i in range(n):
    graph.append(list(input()))

#상하좌우 방향 초기화
dx = [0,0,-1,1]
dy = [-1,1,0,0]

def bfs(s,e):
    visited[s][e] = 1 #방문 처리
    distance = 0
    queue = deque()
    queue.append((s,e,0)) #시작점 삽입
    while queue: #큐가 빌 때 까지
        x,y,d = queue.popleft() #큐에서 값 꺼냄

        for i in range(4): #상하좌우 살펴보기
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue

            #육지이고 한번도 방문하지 않은 경우만
            if graph[nx][ny] == 'L' and visited[nx][ny] == 0:
                queue.append((nx,ny,d+1)) #큐에 인접 정점 삽입
                distance = d+1
                visited[nx][ny] = 1
    return distance

#시작점 지정
result = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 'L':
            visited = [[0] * m for _ in range(n)] # 매번 초기화
            result = max(result, bfs(i,j))

print(result)