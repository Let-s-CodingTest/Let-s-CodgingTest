import sys
input=sys.stdin.readline
nums=[]
def func(x):
    if len(nums) == m:
        print(*nums)
        return
    for i in range(x, n+1):
        if not checked[i]:
            checked[i]=True
            nums.append(i)
            func(i+1)
            nums.pop()
            checked[i] = False
n,m=map(int, input().split())
checked=[False] * (n+1)
func(1)