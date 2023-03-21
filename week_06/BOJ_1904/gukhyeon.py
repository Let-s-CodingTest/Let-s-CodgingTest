import sys
input = sys.stdin.readline
N = int(input())
dp = [0] * (N+5) 
dp[1] = 1
dp[2] = 2
dp[3] = 3
dp[4] = 5
dp[5] = 8

if(N>5):
    for i in range(6,N+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 15746
print(dp[N])
