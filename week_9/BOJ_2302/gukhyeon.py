import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
vip = []
for i in range(M):
    vip.append(int(input()))

dp = [0] * (N+2)
dp[0] = 1
dp[1] = 1
dp[2] = 2

for i in range(3,N+2):
    dp[i] = dp[i-1] + dp[i-2]

idx = 0
result = 1
if M==0:
    print(dp[N])
else:
    for i in range(len(vip)):
        result *= dp[vip[i]-idx-1]
        idx = vip[i]
    result *= dp[N-idx]
    print(result)
        