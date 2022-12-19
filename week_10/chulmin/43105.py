def solution(triangle):
    depth = len(triangle)

    for i in range(1,depth):
        for j in range(i+1):
            #왼쪽 모서리인 경우
            if j == 0:
                triangle[i][j] = triangle[i-1][0] + triangle[i][j]
            #오른쪽 모서리인 경우
            elif i == j:
                triangle[i][j] = triangle[i-1][-1] + triangle[i][j]
            else:
                triangle[i][j] += max(triangle[i-1][j-1], triangle[i-1][j])

    return max(triangle[-1]) #마지막 원소들 중 최솟값 반환