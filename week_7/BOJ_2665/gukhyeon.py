import sys
from collections import deque
import heapq
input = sys.stdin.readline
INF = int(1e9)

n = int(input())
pMap = []
visit = [[0] * n for i in range(n)] 


for i in range(n):
    pMap.append(list(map(int,input().split())))

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def bfs(x,y):
    queue = deque()

    queue.append((x,y))

    while queue:
        x,y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx < 0 or ny < 0 or nx >=n or ny> n:
                continue
            if pMap[nx][ny] == 0:
                

def dijk(start):
    q = []
    heapq.heappush(q,(0,start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)



