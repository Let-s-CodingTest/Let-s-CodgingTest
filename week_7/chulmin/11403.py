#DFS, BFS, 플로이드 워셜로 해결 가능
#플로이드 워셜로 해결

n = int(input())
graph = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    for j in range(n):
        for k in range(n):
            if graph[j][i] and graph[i][k]:
                graph[j][k] = 1
for g in graph:
    print(*g)