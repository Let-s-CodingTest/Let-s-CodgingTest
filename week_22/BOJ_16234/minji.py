import sys
from collections import deque

input=sys.stdin.readline

N, L, R=map(int, input().split())
dx=[-1, 1, 0, 0]
dy=[0, 0, -1, 1]

populations=[list(map(int, input().split())) for _ in range(N)]

#인구이동
def move(tmp, total) :
    population=total//len(tmp)

    for x, y in tmp:
        populations[x][y]=population

#국경선 공유 개수 체크
def bfs(i, j) :
    q=deque()
    q.append([i, j])

    tmp=[] #국경선 공유 좌표
    tmp.append([i, j])

    visit[i][j]=1
    total=populations[i][j]
    while q:
        x, y=q.popleft()
        for i in range(4) :
            nx, ny=x+dx[i], y+dy[i]
            if 0<=nx<N and 0<=ny<N :
                if visit[nx][ny]==0 and L<=abs(populations[nx][ny]-populations[x][y])<=R :
                    tmp.append([nx, ny])
                    visit[nx][ny]=1
                    q.append([nx, ny])
                    total+=populations[nx][ny]
    return tmp, total

answer=0
while True:
    flag=0
    visit=[[0]*N for _ in range(N)]

    for i in range(N) :
        for j in range(N) :
            if visit[i][j]==0 :
                tmp, total=bfs(i, j) #국경선 공유 좌표 찾기

                if len(tmp)>1 :
                    flag=1
                    move(tmp, total)

    if flag==0 :
        break

    '''
    for i in range(N) :
            print(*populations[i])
    print("-------------------")
    '''
    answer+=1
print(answer)