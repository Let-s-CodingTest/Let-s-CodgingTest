import sys
input = sys.stdin.readline
n,m = map(int, input().split())
nums = list(map(int, input().split()))
sums = [0]
tmp = 0

#배열 합 구하기
for i in range(len(nums)):
    tmp+=nums[i]
    sums.append(tmp)

for i in range(m):
    s,e = map(int, input().split())
    print(sums[e] - sums[s-1])