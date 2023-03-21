import sys
from collections import deque
input=sys.stdin.readline

m, n, k=map(int, input().split())
boards=[[0]*n for _ in range(m)]
dx=[0, 0, -1, 1]
dy=[1, -1, 0, 0]
for _ in range(k) :
    x1, y1, x2, y2=map(int, input().split())
    for i in range(y1, y2):
        for j in range(x1, x2) :
            boards[i][j]=1
# for i in range(m) :
#     print(*boards[i])
def bfs(a, b):
    q=deque()
    q.append([a, b])
    visit[a][b]=1
    count=1
    while q:
        x, y=q.popleft()

        for i in range(4) :
            nx, ny=x+dx[i], y+dy[i]

            if 0<=nx<m and 0<=ny<n and visit[nx][ny]==0:
                if boards[nx][ny]==0 :
                    q.append([nx, ny])
                    visit[nx][ny]=1
                    count+=1
    return count
cnt=0
area=[]
visit=[[0]*n for _ in range(m)]
for i in range(m) :
    for j in range(n) :
        if visit[i][j]==0 and boards[i][j]==0:
            area.append(bfs(i, j))
            cnt+=1
area.sort()
print(cnt)
print(*area)