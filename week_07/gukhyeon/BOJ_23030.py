import sys
import heapq

input = sys.stdin.readline

N, V, E = map(int,(input().split()))

A, B = map(int, input().split())

d = list(map(int,input().split()))

people = list(map(int,input().split()))

graph = [[] for _ in range(V+1)]

for i in range(E):
    a, b, c = map(int, input().split())
    graph[a].append((b,c))
    graph[b].append((a,c))

def dijk(s,d ):
    d[s] = 0
    q = []
    heapq.heappush(q, (d[s],s))

    while q:
        dist, node = heapq.heappop(q)
        if d[node] < dist:
            continue

        for j in graph[node]:
            weighted_distance = dist + j[1]
            if weighted_distance < d[j[0]]:
                d[j[0]] = weighted_distance
                heapq.heappush(q, (weighted_distance, j[0]))
result = 0
for i in range(N):
    KIST = 0
    FOOD = 0
    INF = int(1e9)
    distances = [INF] * (V+1)
    dijk(people[i], distances)
    if distances[d[0]] == INF:
        KIST = -1
    if distances[d[1]] == INF:
        FOOD = -1
    if distances[d[0]] != INF:
        KIST = distances[d[0]]
    if distances[d[0]] != INF:
        FOOD = distances[d[1]]
    result += KIST + FOOD