import sys
input = sys.stdin.readline

# n=0 -> 1
# n=1 -> 3
# n=2 -> 7 : 6+1
# n=3 -> 17 : 14+3
# n=4 -> 41 : 34+17

N = int(input())

dp = [0]*(N+2)
dp[0] = 1
dp[1] = 3

for i in range(2, N+1):
    dp[i] = (dp[i-1]*2 + dp[i-2]) % 9901
print(dp[N])
