import sys
input = sys.stdin.readline

N = int(input())
M = int(input())
vip = [0]+[int(input()) for _ in range(M)]+[N+1]
change = [vip[i+1]-vip[i]-1 for i in range(M+1)]
dp = [0] * (N+1)

def get_change(n):
    dp[0] = 1
    dp[1] = 1

    if dp[n] != 0:
        return dp[n]
    dp[n] = get_change(n-1) + get_change(n-2)
    return dp[n]

answer = 1
for c in change:
    answer *= get_change(c)

print(answer)