import sys
input = sys.stdin.readline

def dfs():
    if len(nums) == m:
        print(*nums)
        return

    for i in range(1, n+1):
        if not checked[i]:
            checked[i] = True
            nums.append(i)
            dfs()
            checked[i] = False
            nums.pop()

n,m = map(int, input().split())
nums = []
checked = [False] * (n+1)
dfs()