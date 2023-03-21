n,m = map(int, input().split())
nums = []
def dfs():
    if len(nums) == m:
        print(*nums)
        return
    for i in range(1,n+1):
        nums.append(i)
        dfs()
        nums.pop()
dfs()