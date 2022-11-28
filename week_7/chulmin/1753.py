import heapq
import sys
input = sys.stdin.readline

#노드, 간선의 개수 입력
n,m = map(int, input().split())

INF = int(1e9)

#시작 노드 입력
start = int(input())

#그래프 입력
graph = [[] for _ in range(n+1)]

#그래프 형태 입력받기
for i in range(m):
    s,e,w = map(int, input().split())
    graph[s].append((e,w)) #각 노드의 끝 정점과 가중치 입력

#최단 거리 테이블
distance = [INF] * (n+1) #무한으로 초기화

def dijkstra(x):
    q = []
    heapq.heappush(q, (0, start)) #시작 노드 삽입, 최소 힙 사용
    distance[start] = 0

    while q:
        #(거리, 노드)
        dist, now_node = heapq.heappop(q)
        if distance[now_node] < dist:
            continue
        for i in graph[now_node]:
            near_node = i[0]
            cost = dist + i[1]
            #구해준 비용 < 기존 인접 노드의 최단 거리
            if cost < distance[near_node]:
                #최단 거리 갱신
                distance[near_node] = cost
                heapq.heappush(q, (cost, near_node))

dijkstra(start)

for i in range(1, n+1):
    if distance[i] == INF:
        print("INF")
    else:
        print(distance[i])