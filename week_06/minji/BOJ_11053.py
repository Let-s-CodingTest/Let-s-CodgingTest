from bisect import bisect_left
import sys
input=sys.stdin.readline

n=int(input())
arr=list(map(int, input().split()))
dp=[1]*n
'''
#dp 풀이
for i in range(1, n):
    for j in range(0, i) :
        if arr[j]<arr[i]:
            dp[i]=max(dp[j]+1, dp[i])
print(max(dp))
'''
#dp + 이진 탐색
x=[arr[0]]
for i in range(n):
    if x[-1]<arr[i]:
        x.append(arr[i])
        dp.append(dp[-1]+1)
    else:
        index=bisect_left(x, arr[i])
        x[index]=arr[i]
print(dp[-1])
print(x)

