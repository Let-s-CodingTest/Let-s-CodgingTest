#빙고판
nums = [list(map(int, input().split())) for i in range(5)]

#사회자 입력 -> 일차원 리스트로 입력받게 함. (3차원 반복문으로 끊기 위해)
mc = []
for i in range(5):
    mc += list(map(int, input().split()))
print(mc)

def check_bingo():
    bingo = 0

    #가로 확인
    for num in nums:
        if num.count(0) == 5:
            bingo+=1

    # 세로 확인
    for i in range(5):
        y = 0
        for j in range(5):
            if nums[j][i] == 0:
                y+=1

        if y == 5:
            bingo+=1

    # 왼 - 대각선
    left_d = 0
    for i in range(5):
        if nums[i][i] == 0:
            left_d +=1
    if left_d == 5:
        bingo+=1

    # 오 - 대각선
    right_d = 0
    for i in range(5):
        if nums[i][4-i] == 0:
            right_d +=1
    if right_d == 5:
        bingo+=1

    return bingo

count = 0
for i in range(25):
    for x in range(5):
        for y in range(5):
            if mc[i] == nums[x][y]:
                nums[x][y] = 0
                count+=1

    if count >=12: #적어도 빙고가 이뤄질 수 있는 최소한의 경우, 아직 빙고가 이뤄진지는 알 수 없음
        if check_bingo() >= 3: #빙고의 개수가 3 이상이면
            print(i+1) #빙고판은 0번부터 돌기 때문에 +1
            break