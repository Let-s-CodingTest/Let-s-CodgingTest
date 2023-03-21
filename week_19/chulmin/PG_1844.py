from collections import deque

def solution(maps):
    answer= bfs(0,0,maps)
    return -1 if answer == 1 else answer

dx=[-1,1,0,0] #상,하
dy=[0,0,-1,1] #좌,우
def bfs(x,y,maps):
    queue=deque()
    queue.append((x,y)) #시작 지점 방문 처리

    row = len(maps)
    col = len(maps[0])

    while queue: #큐가 있는 동안
        #큐의 원소를 하나 제거
        x,y=queue.popleft()

        for i in range(4):
            nx=x+dx[i]
            ny=y+dy[i]
            if nx < 0 or ny < 0 or nx >= row or ny >= col:
                continue

            if maps[nx][ny] == 0:
                continue

            if maps[nx][ny] == 1:
                maps[nx][ny] = maps[x][y] + 1
                queue.append((nx,ny))
    return maps[row-1][col-1]