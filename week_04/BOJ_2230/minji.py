import sys

n, m=map(int, input().split())

arr=[int(input()) for _ in range(n)]
arr.sort()

start=0
end=1
ans=sys.maxsize
while end<len(arr):
    diff=arr[end]-arr[start]
    if diff==m :
        ans=diff
        break
    if diff<m : #m보다 작으므로 차이를 증가시키는 방향으로
        end+=1
        continue
    start+=1
    ans=min(ans, diff)

print(ans)