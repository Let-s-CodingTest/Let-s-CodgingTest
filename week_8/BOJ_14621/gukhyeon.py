from collections import deque
import sys

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)

    if a < b:
        parent[b] = a
    else:
        parent[a] = b

input = sys.stdin.readline

N, M = map(int, input().split())
unis = list(map(str, input().split()))
edges = []
result = 0
parent = [0] * (N+1)
for i in range(1, N+1):
    parent[i] = i

for i in range(M):
    u, v, d = map(int,input().split())
    edges.append((d, u, v))
    

edges.sort()
last = 0 
cnt = 0
for edge in edges:
    d, u, v = edge
    if find_parent(parent,u) != find_parent(parent,v) and unis[u-1] != unis[v-1]:
        union_parent(parent,u, v)
        result += d
        last = d
        cnt += 1
     
if cnt == N-1:
    print(result)
else:
    print(-1)
