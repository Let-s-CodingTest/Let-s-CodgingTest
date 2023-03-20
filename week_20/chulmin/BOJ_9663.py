import sys
input=sys.stdin.readline

isused=[0]*(30)
isused1=[0]*(30)
isused2=[0]*(30)
cnt=0
def func(cur):
    global cnt

    if cur == n:
        cnt+=1
        return
    for i in range(n):
        if isused[i] or isused1[cur+i] or isused2[cur-i+n-1]:
            continue
        isused[i] = 1
        isused1[i+cur] = 1
        isused2[cur-i+n-1]=1
        func(cur+1)
        isused[i] = 0
        isused1[i+cur]=0
        isused2[cur-i+n-1]=0
n=int(input())
func(0)
print(cnt)