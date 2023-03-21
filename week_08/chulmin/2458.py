#키 순서
import sys
input = sys.stdin.readline
#입력
N, M = map(int, input().split())
height = [[0 for _ in range(N+1)] for _ in range(N+1)]
answer = 0

for _ in range(M):
    tall, short = map(int, input().split())
    height[tall][short] = 1

#플로이드 와샬 알고리즘
for k in range(1, N+1):
    for i in range(1, N+1):
        for j in range(1, N+1):
            if height[i][j] == 1 or (height[i][k] ==1 and height[k][j] == 1):
                height[i][j] = 1

for i in range(1, N+1):
    known_height = 0
    for j in range(1, N+1):
        known_height += height[i][j] + height[j][i]
    if known_height == N-1:
        answer += 1
print(answer)