import sys
input = sys.stdin.readline

n, m = map(int, input().split())

nums = []
for _ in range(n):
    nums.append(int(input()))
#정렬
nums.sort()
#투포인터 활용
left = 0
right = 1
result = sys.maxsize # sys.maxsize : int의 최대값
while left < n and right < n:
    value = nums[right] - nums[left]
    if value == m:
        print(m)
        exit(0)
    if value < m:
        right+=1
        continue
    left+=1
    result = min(result, value);

print(result)
