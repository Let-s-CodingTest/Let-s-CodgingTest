import heapq
import sys
n, m, x=map(int, input().split())
graph=[[] for _ in range(n+1)]


for _ in range(m) :
    a, b, c=map(int, input().split())
    graph[a].append([b, c])

def dijkatra(start):
    dist = [sys.maxsize] * (n+1)
    dist[start]=0
    q=[]
    heapq.heappush(q, [0, start])

    while q:
        weight, node=heapq.heappop(q)
        for next_node, wei in graph[node]:
            if dist[next_node]>wei+weight:
                heapq.heappush(q, [wei+weight, next_node])
                dist[next_node]=wei+weight
    return dist

ans=0
for i in range(1, n+1):
    go=dijkatra(i)
    back=dijkatra(x)
    ans=max(ans, go[x]+back[i])
print(ans)