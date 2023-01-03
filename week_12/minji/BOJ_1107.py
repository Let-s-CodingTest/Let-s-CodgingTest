import sys

input=sys.stdin.readline
n=int(input())
m=int(input())
broken=list(map(int, input().split()))

ans=abs(100-n) # + 또는 -로만 이동하는 경우
if n==100 : print(0)
else:
    for nums in range(1000001):
        nums=str(nums)
        for j in range(len(nums)) :
            if int(nums[j]) in broken : break
            elif j==len(nums)-1:
                ans=min(ans, abs(int(nums)-n)+len(nums))
print(ans)
