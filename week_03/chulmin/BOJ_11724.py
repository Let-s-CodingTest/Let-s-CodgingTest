#DFS로 짜면 파이썬의 재귀 제한에 걸려 RE 발생
#sys.setrecursionlimit을 통해 재귀 제한 범위를 늘린다,

import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000);
n, e = map(int, input().split())
graph = [[] for i in range(n + 1)]
visited = [False] * (n+1)


def dfs(n):
    visited[n] = True
    # 인접 정점의 요소 중에
    for i in graph[n]:
        # 방문되지 않은 인접정점이 있으면
        if not visited[i]:
            dfs(i)  # DFS 재귀로 호출함으로써, 방문 처리


for i in range(e):
    start_node, end_node = map(int, input().split())
    # 그래프를 인접 리스트로 표현
    # 무방향 그래프이므로 양쪽 방향으로 엣지를 다 저장.
    graph[start_node].append(end_node)
    graph[end_node].append(start_node)

count = 0
for i in range(1, n + 1):
    if not visited[i]:
        count += 1
        dfs(i)

print(count)
