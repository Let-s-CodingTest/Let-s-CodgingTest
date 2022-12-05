from collections import deque
import sys

input = sys.stdin.readline
N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
degree = [0 for _ in range(N+1)]

q = deque()
result = []

for i in range(M):
    a, b = map(int, sys.stdin.readline().rstrip().split())
    graph[a].append(b)
    degree[b] += 1

for i in range(1, N+1):
    if degree[i] == 0:
        q.append(i)

while q:
    temp= q.popleft()
    result.append(temp)
    for i in graph[temp]:
        degree[i] -= 1
        if degree[i] == 0:
            q.append(i)

print(*result)

