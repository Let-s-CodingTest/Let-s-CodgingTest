'''
dp[i][0]은 i번째 줄에는 사자를 배치하지 않는 경우
dp[i][1]은 i번째 줄 왼쪽에 사자를 배치한 경우
dp[i][2]는 i번째 줄 오른쪽에 사자를 배치한 경우
'''
n=int(input())

dp=[[0]*3 for _ in range(n+1)]

for i in range(3):
    dp[1][i]=1
for i in range(2, n+1) :
    dp[i][0]=dp[i-1][0]+dp[i-1][1]+dp[i-1][2]
    dp[i][1]=dp[i-1][0]+dp[i-1][2]
    dp[i][2]=dp[i-1][0]+dp[i-1][1]

print(sum(dp[n]))