#다익스트라 응용 풀이 문제
from heapq import heappush,heappop
import sys
input = sys.stdin.readline
v,e = map(int, input().split())

arr = [[] for _ in range(v+1)]
ans = [[float('inf') for _ in range(v + 1)] for _ in range(v+1)]
q = []
for _ in range(e):
    x,y,z = map(int,input().split())
    arr[x].append([y,z])
    ans[x][y] = z
    heappush(q,[z,x,y])

def dijkstra():
    while q:
        dist,s,e = heappop(q)
        if s == e:
            print(dist)
            break

        if ans[s][e] > dist:
            for i in arr[e]:
                if ans[s][i[0]] >= dist + i[1]:
                    ans[s][i[0]] = dist + i[1]
                    heappush(q, [dist + i[1], s, i[0]])
    else:
        print(-1)

dijkstra()