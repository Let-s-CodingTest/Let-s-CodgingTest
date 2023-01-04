#pypy3으로 제출함.

import sys
input = sys.stdin.readline
n, m = map(int, input().split()) #나무의 수, 집에 가져가려는 나무 길이
h = list(map(int, input().split()))

start = 0
end = max(h)

while start <= end:
    sum = 0
    mid = (start + end) // 2
    for i in h:
        if i > mid:
            sum += i - mid
    if sum >= m: #원하는 나무 높이 보다 더 많이 잘렸다면
        start = mid + 1 # 높이를 높여줌으로써, 나무가 적게 잘리도록 한다.
    else: # 원하는 나무 높이 보다 더 조금 잘렸으면
        end = mid - 1 # 톱의 길이를 낮춤으로써 더 많은 나무가 잘리도록 한다.

print(end)

