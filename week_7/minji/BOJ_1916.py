import sys, heapq
input=sys.stdin.readline
INF=sys.maxsize
n=int(input())
m=int(input())
graph=[[] for _ in range(n+1)]

for _ in range(m) :
    a, b, c=map(int, input().split())
    graph[a].append([b, c])

start, end=map(int, input().split())

def dijkstra(x) :
    distance=[INF]*(n+1)
    distance[x]=0
    q=[]
    heapq.heappush(q, [0, x])
    while q :
        cost, node=heapq.heappop(q)

        if distance[node]<cost : continue

        for next_node, weight in graph[node]:
            next_cost=weight+cost
            if distance[next_node]>next_cost :
                distance[next_node]=next_cost
                heapq.heappush(q, [next_cost, next_node])
    return distance
dijkstra_start=dijkstra(start)
print(dijkstra_start[end])