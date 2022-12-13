n=int(input())
m=int(input())

vips=[int(input()) for _ in range(m)]
dp=[0]*(n+1)
dp[0]=1
dp[1]=1
for i in range(2, n+1) :
    dp[i]=dp[i-1]+dp[i-2]

ans=1
start=0
for vip in vips :
    length=vip-start-1
    start=vip
    ans*=dp[length]

ans*=dp[n-start]
print(ans)