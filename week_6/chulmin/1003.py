def fibo(n):
    z_count = 0
    o_count = 0
    dp = [0] * (n+1)

    if n==0:
        z_count+=1
        dp[n] = 0

    elif n==1:
        o_count+=1
        dp[n] = 1

    else:
        dp[n] = dp[n-2] + dp[n-1] # dp[1], dp[2]

    print(z_count, o_count)

n = int(input())
for _ in range(n):
    n = int(input())
    fibo(n)