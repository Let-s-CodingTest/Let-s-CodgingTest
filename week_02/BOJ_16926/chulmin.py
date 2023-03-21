import sys
input = sys.stdin.readline

n,m,r = map(int, input().split())

nums = []

for i in range(n):
    data = list(map(int, input().split()))
    nums.append(data)

for _ in range(r):
    for i in range(min(n,m) // 2): #안, 바깥 사각형 모두 고려
        x,y = i,i # 시작점 설정
        value = nums[i][i]

        #아래로 이동
        for j in range(i+1, n-i):
            x = j
            temp = nums[x][y]
            nums[x][y] = value
            value = temp

        #오른쪽 이동
        for j in range(i+1,m-i): #i가 0이면, 1부터 ~ m-i까지
            y = j
            temp = nums[x][y]
            nums[x][y] = value
            value = temp

        #위로 이동
        for j in range(i+1, n-i):
            x = n - 1 - j
            temp = nums[x][y]
            nums[x][y] = value
            value = temp;

        #왼쪽으로 이동
        for j in range(i+1, m-i):
            y = (m-1) - j #전체 열- 1
            temp = nums[x][y]
            nums[x][y] = value
            value = temp

for i in range(n):
    for j in range(m):
        print(nums[i][j], end=' ')
    print()

