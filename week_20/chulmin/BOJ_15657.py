import sys
input=sys.stdin.readline
n,m=map(int,input().split())
arr=list(map(int, input().split()))
arr.sort()
nums=[]
def func(x):
    if len(nums) == m:
        print(*nums)
        return
    for i in range(x,n):
        nums.append(arr[i])
        func(i)
        nums.pop()
func(0)