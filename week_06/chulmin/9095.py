n = int(input())

def d(n):
    dp = [0] * 11 #n이 3미만일 때 size를 n+1로 초기화 하면, 런타임 에러 발생 -> 리스트 초기화 오류 
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for i in range(4, n+1):
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

    return dp[n]

for _ in range(n):
    print(d(int(input())))