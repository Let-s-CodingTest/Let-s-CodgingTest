import sys
from collections import deque
input = sys.stdin.readline

maxValue = 0
width, height = map(input,(input().split()))
graph = []
for i in range(width):
    graph.append(list(map(str,(input()))))
visited =[[0] * (width) for i in range(height)]
dx = [-1,1,0,0]
dy = [0, 0, -1, 1] 



def bfs(x, y):
    queue = deque()
    queue.append((x,y))
    while queue:
        x, y= queue.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >= width or ny >= height:
                continue
            if graph[nx][ny] == 0:
                continue
            if graph[nx][ny] == 'L':
                visited[nx][ny] = 1 
                graph[nx][ny] = graph[x][y] +1
                maxValue if graph[nx][ny] > maxValue else graph[nx][ny]
                queue.append((nx, ny))
    return maxValue         




























print(bfs(0,0))