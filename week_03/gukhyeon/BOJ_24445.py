import sys
from collections import deque
input = sys.stdin.readline

N,M,R = map(int,input().split())
edge = [[] for i in range(N+1)]
visited=[]
for i in range(N+1):
    visited.append(0)
cnt = 1
queue = deque([R])
visited[R] = 1

for i in range(M):
    u,v = map(int,input().split())
    edge[u].append(v)
    edge[v].append(u)

for i in range(1,N+1):
    edge[i].sort(reverse = True)

while queue:
    v = queue.popleft()
    for i in edge[v]:
        if visited[i]:
            continue
        cnt+=1
        visited[i] = cnt
        queue.append(i)
print(*visited[1:], sep="\n")