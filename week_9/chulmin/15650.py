n,m = map(int, input().split())
checked = [False] * (n+1)
nums = []

def dfs(start):
    if len(nums) == m:
        print(*nums)
        return

    for i in range(start, n+1):
        if not checked[i]:
            checked[i] = True
            nums.append(i)
            dfs(i+1)
            checked[i] = False
            nums.pop()
dfs(1)