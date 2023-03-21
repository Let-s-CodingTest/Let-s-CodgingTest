import sys
input=sys.stdin.readline

res=[]

def func(arr):
    if len(res) == m:
        print(*res)
        return
    for i in range(len(arr)):
        if not checked[i]:
            checked[i]=True
            res.append(arr[i])
            func(arr)
            res.pop()
            checked[i]=False

n,m=map(int,input().split())
arr=sorted(list(map(int, input().split())))
checked=[False] * (n+1)
func(arr)