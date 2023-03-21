#Top-down 방식
# 1. 큰 값을 작은 값으로 쪼갤 수 있다.
# 2. 쪼개진 작은 값은 큰 값을 구하는데 사용될 수 있다.
dp_table = {1:0}
def dp_top_down(n):
    if n in dp_table.keys():
        return dp_table[n]

    #3과 2로 모두 떨어지는 수
    if n % 3 == 0 and n % 2 ==0:
        dp_table[n] = min(dp(n//3)+1,dp(n//2)+1)

    #3으로 나누어 떨어지는 수
    elif n % 3 == 0:
        dp_table[n] = min(dp(n//3)+1, dp(n-1) +1)

    #2로 나누어 떨어지는 수
    elif n%2==0:
        dp_table[n] = min(dp(n//2)+1, dp(n-1)+1);
    #3,2 모두 나누어 떨이지지 않는 수
    else:
        dp_table[n] = dp(n-1)+1
    return dp_table[n]

def dp_bottom_up(n):
    dp = [0] * (n+1)

    for i in range(2, n+1):
        dp[i] = dp[i-1] + 1 #1을 뺸 수가 1이 되는 최소 횟수 + 1을 뺴준 연산 1회

        if i%2==0:
            dp[i] = min(dp[i], dp[i//2] + 1) #i를 2로 나눠준 수가 1이 되는 최소 회수 + 2로 나눈 연산 1회
        if i%3==0:
            dp[i] = min(dp[i], dp[i//3] + 1) #i//3이 1이되는 최소 횟수 + 3으로 나눈 연산 1회

    return dp[i]

print(dp_bottom_up(int(input())))
