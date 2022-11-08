import sys
import bisect
input=sys.stdin.readline

T=int(input())
n=int(input())
a=list(map(int, input().split()))
m=int(input())
b=list(map(int, input().split()))

subarrA=[]
#a의 모든 부분배열 합
for i in range(n):
    for j in range(i, n):
        subarrA.append(sum(a[i:j+1]))

subarrB=[]
#b의 모든 부분배열 합
for i in range(m):
    for j in range(i, m):
        subarrB.append(sum(b[i:j+1]))
subarrB.sort()

answer=0
for i in subarrA:
    diff=T-i
    start=bisect.bisect_left(subarrB, diff)
    end=bisect.bisect_right(subarrB, diff)
    answer+=end-start

print(answer)