import sys
input=sys.stdin.readline
k, n=map(int, input().split())
lines=[list(int(input()) for _ in range(n))]

start, end=1, max(lines)
while start<=end:
    mid=(start+end)//2
    cnt=0
    for line in lines :
        cnt+=(line//mid)
    if cnt>=n:
        start=mid+1
    else:
        end=mid-1
print(end)
