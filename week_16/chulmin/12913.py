def solution(land):
    n = len(land)
    # dp[i][j] = i행 j열에서 점수의 최대값
    # dp 초기화
    dp = [[0,0,0,0]] + land
    for i in range(1, n+1):
        # 이전 행에서 같은 열을 제외한 값 중 최대값과 현재값을 더한다.
        dp[i][0] += max(dp[i-1][1], dp[i-1][2], dp[i-1][3])
        dp[i][1] += max(dp[i-1][0], dp[i-1][2], dp[i-1][3])
        dp[i][2] += max(dp[i-1][0], dp[i-1][1], dp[i-1][3])
        dp[i][3] += max(dp[i-1][0], dp[i-1][1], dp[i-1][2])

    return max(dp[n])
print(solution(land=[[1,2,3,5],[5,6,7,8],[4,3,2,1]]))