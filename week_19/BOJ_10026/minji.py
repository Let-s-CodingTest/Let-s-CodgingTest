import sys
from collections import deque

input=sys.stdin.readline

n=int(input())
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]

graphs=[list(map(str, input().rstrip())) for _ in range(n)]

def bfs(visit, a, b):
    q=deque()
    q.append([a, b])
    visit[a][b]=1
    while q :
        x, y=q.popleft()
        for i in range(4) :
            nx=x+dx[i]
            ny=y+dy[i]
            if 0<=nx<n and 0<=ny<n and visit[nx][ny]==0:
                if graphs[x][y]==graphs[nx][ny] :
                    visit[nx][ny]=1
                    q.append([nx, ny])

cnt_rgb=0
visit=[[0]*n for _ in range(n)]
for i in range(n) :
    for j in range(n) :
        if visit[i][j]==0 :
            bfs(visit, i, j)
            cnt_rgb += 1

for i in range(n) :
    for j in range(n) :
        if graphs[i][j]=='R' :
            graphs[i][j]='G'

cnt_gb=0
visit=[[0]*n for _ in range(n)]
for i in range(n) :
    for j in range(n) :
        if visit[i][j]==0 :
            bfs(visit, i, j)
            cnt_gb += 1

print(cnt_rgb, cnt_gb, end=' ')