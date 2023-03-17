import sys
sys.setrecursionlimit(1000000)
input=sys.stdin.readline
n=int(input())

graph=[]
for i in range(n):
    graph.append(list(input().rstrip()))
visited=[[False] * n for _ in range(n)]
normal, disabled = 0,0 #정상, 색맹인 경우 카운트 변수
dx=[-1,1,0,0]
dy=[0,0,-1,1]
def dfs(x,y):
    #방문 처리
    visited[x][y] = True
    #현 지점에서 상,하,좌,우를 바라봄
    for i in range(4):
        nx= x+dx[i]
        ny= y+dy[i]
        #이동된 정점이 범위를 벗어난 경우
        if nx < 0 or ny < 0 or nx >= n or ny >= n:
            continue
        #이동된 정점이 방문되지 않은 경우
        if visited[nx][ny] == False:
            #이동된 정점의 색깔이 이동 전 정점의 색과 같은 경우
            if graph[nx][ny] == graph[x][y]:
                dfs(nx,ny) #이동 된 정점에서 상,하,좌,우 살펴보며 색이 같은 구역을 탐색하도록 한다.

for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            dfs(i,j)
            normal+=1

visited=[[False] * n for _ in range(n)]
#적록 색약 구해주기
for i in range(n):
    for j in range(n):
        if graph[i][j] == 'G':
            graph[i][j] = 'R'

for i in range(n):
    for j in range(n):
        if visited[i][j] == False:
            dfs(i,j)
            disabled+=1
print(normal, disabled)