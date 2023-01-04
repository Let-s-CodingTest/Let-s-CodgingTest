# 입국심사
# 친구들 총 m명, 입국 심사대는 n개
# 모든 사람이 심사를 받는데 걸리는 시간이 최소
import sys
input = sys.stdin.readline
N, M = map(int, input().split())

arr = []
for _ in range(N):
    arr.append(int(input()))

answer = 0
left = 0
right = max(arr)*M
while left <= right:
    mid = (left+right)//2

    people = 0
    for time in arr:
        people += mid//time
        if people > M:
            break

    if people < M:
        left = mid + 1
    else:
        right = mid - 1
        answer = mid
print(answer)