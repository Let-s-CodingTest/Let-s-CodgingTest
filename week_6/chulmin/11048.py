#input width, height
n,m = map(int, input().split())

#for graph
g = []

#Input the number of graph
for i in range(n):
    g.append(list(map(int, input().split())))

# define dp_table
dp = [[0] * (m+1) for _ in range(n+1)]

#recursive
for i in range(1, n+1):
    for j in range(1, m+1):
        dp[i][j] = dp[i-1][j-1] + max(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])

print(dp[n][m])