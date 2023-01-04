n,m = map(int, input().split())
nums = []

def dfs(start):
    if len(nums) == m:
        print(*nums)
        return

    for i in range(start,n+1):
        nums.append(i)
        dfs(i)
        nums.pop()
dfs(1)