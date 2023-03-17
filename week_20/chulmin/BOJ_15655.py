import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=list(map(int, input().split()))
arr.sort()
nums=[]
checked=[False] * (n+1)
def func(x):
    if len(nums)==m:
        print(*nums)
        return
    for i in range(x,n):
        if not checked[i]:
            checked[i]=True
            nums.append(arr[i])
            func(i+1)
            nums.pop()
            checked[i]=False
func(0)