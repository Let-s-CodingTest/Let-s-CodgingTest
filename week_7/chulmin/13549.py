from collections import deque
MAX = 10000 + 1
check = [False] * MAX
dist = [-1] * MAX

n,k = map(int, input().split())
q = deque()
q.append(n)
check[n] = True
dist[n] = 0

while q:
    now = q.popleft()
    #순간 이동 하는 경우
    if now*2 <= MAX and check[now*2] == False:
        check[now*2] = True
        dist[now*2] = dist[now]
    #x+1로 이동하는 경우
    if now + 1 <= MAX and check[now+1] == False:
        q.append(now+1)
        check[now+1] = True
        dist[now+1] = dist[now] + 1
    #x-1로 이동한 경우
    if now - 1 >= 0 and check[now-1] == False:
        q.append(now-1)
        check[now-1] = True
        dist[now-1] = dist[now] + 1
print(dist[k])