import sys
input = sys.stdin.readline

n,m = map(int, input().split())
nums = [[0] * (n+1)]
print(nums)
D = [[0] * (n+1) for _ in range(n+1)]

#원본 리스트 데이터 저장
for i in range(n):
    nums_row = [0] + [int(x) for x in input().split()]
    nums.append(nums_row)

#합 배열 구하기
for i in range(1, n+1):
    for j in range(1, n+1):
        D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + nums[i][j]

for i in range(m):
    x1,y1,x2,y2 = map(int,input().split())
    print(D[x2][y2] - D[x1-1][y2] - D[x2][y1-1] + D[x1-1][y1-1])


    #합배열 -> 위에 행 값 + 앞에 열 값 - 공통 대ㅑ각선 + 리스트 값
    # 리스트 값 = 합배열 - 위에행 값 - 앞에 열 값 + 공통 대각선
