import sys
input = sys.stdin.readline

n = int(input()) #좌석의 개수, n
m = int(input()) #고정석 개수
vip = [int(input()) for _ in range(m)]
answer = 1
dp = [1 for _ in range(n+1)]

if n >=2:
    dp[2] = 2
    for i in range(3,n+1):
        dp[i] = dp[i-1] + dp[i-2]

if m > 0:
    pre = 0
    #vip = 4,7
    for j in range(m): #고정석의 개수만큼 반복
        answer *= dp[vip[j] - 1 - pre]
        pre = vip[j]
    answer *= dp[n - pre]
else:
    answer = dp[n]
print(answer)