# n = 1 : 3
# n = 2 : 7
# n = 3 : 17
# n = 4 : 41
import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * (N+2)
dp[0] = 1
dp[1] = 3
dp[2] = 7
dp[3] = 17
dp[4] = 41
if(N>=5):
    for i in range(5,N+1):
        dp[i] = (dp[i-1]*2 + dp[i-2])%9901
print(dp[N])


