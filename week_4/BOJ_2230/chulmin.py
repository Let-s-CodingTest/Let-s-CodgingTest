import sys
input = sys.stdin.readline

n, m = map(int, input().split())

nums = []
for _ in range(n):
    nums.append(int(input()))

#정렬
nums.sort()
#투포인터 활용
s = 0
e = len(nums) - 1
result = 1e9
while s != e:
    value = abs(nums[s] - nums[e])
    if value >= m:
        result = min(result, value);
    if value < m:
        s+=1

print(result)
