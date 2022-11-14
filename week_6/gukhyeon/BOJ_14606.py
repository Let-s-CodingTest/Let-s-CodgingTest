import sys
input = sys.stdin.readline
dp = [0] * 11
N = int(input())

dp[1] = 0
dp[2] = 1

for i in range(3, N + 1):
    n = i // 2
    dp[i] = n * (i-n) + dp[n] + dp[i-n]
print(dp[N])

