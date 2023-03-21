import sys
n=int(input())
waters=list(map(int, input().split()))

waters.sort()

left=0
right=len(waters)-1
ans=abs(waters[left]+waters[right])
answer=[waters[left], waters[right]]
while left<right:
    tmp=waters[left]+waters[right]
    if ans>abs(tmp):
        answer=[waters[left], waters[right]]
        ans=abs(tmp)
    if tmp>0 :
        right-=1
    else:
        left+=1
print(answer[0], answer[1])
