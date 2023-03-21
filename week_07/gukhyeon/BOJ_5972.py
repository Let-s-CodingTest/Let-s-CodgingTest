import sys
import heapq
input = sys.stdin.readline
INF = int(1e9)

def dijk(start):
    q = []
    heapq.heappush(q,(0, start))
    distance[start ] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for v, w in graph[now]:
            cost = dist+w
            if cost < distance[v]:
                distance[v] = cost
                heapq.heappush(q,(cost, v))

N, M = map(int,input().split())
graph = [[] for i in range(N+1)]
distance = [INF ] * (N+1)
for i in range(M):
    a, b, c = map(int,input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))
dijk(1)
print(distance[N])