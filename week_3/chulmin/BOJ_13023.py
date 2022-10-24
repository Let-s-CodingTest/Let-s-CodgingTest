import sys

input = sys.stdin.readline
sys.setrecursionlimit(10000)


def dfs(i, count):
    global result

    visited[i] = True  # 친구 관계 맺음

    if count == 5:
        result = 1

    for f in friends[i]:  # 인접한 친구 리스트 중에서
        if not visited[f]:  # 친구 관계를 맺지 않았으면
            dfs(f, count + 1)  # 재귀 호출
            visited[i] = False  # 다음 조사를 위해 false로 처리
            if result:
                return


n, m = map(int, input().split())  # 공백을 기준으로 사람의 수와 친구 관계 수 입력
friends = [[] for _ in range(n)]
visited = [False] * n
result = 0

for i in range(m):
    a, b = map(int, input().split())
    friends[a].append(b)
    friends[b].append(a)

for i in range(n):
    if not visited[i]:
        dfs(i, 1)
        visited[i] = False
    if result:
        break

print(result)
