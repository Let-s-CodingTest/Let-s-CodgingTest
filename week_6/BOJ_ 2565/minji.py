'''
교차하지 않기 위해서는 B전봇대와 연결된 번호가 증가하는 수열이어야함.
이를 해결하기 위해 가장 긴 증가하는 부분수열로 해결
'''
import sys

input=sys.stdin.readline
n=int(input())
lines=[list(map(int, input().split())) for _ in range(n)]
lines.sort() #A전봇대 기준으로 정렬
dp=[1]*n

for i in range(n):
    for j in range(0, i):
        if lines[i][1]>lines[j][1]:
            dp[i]=max(dp[i], dp[j]+1)

print(n-max(dp))
