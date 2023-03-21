import sys
input = sys.stdin.readline

x,y = map(int,input().split())
z = (y * 100) // x #승률

#절대 변하지 않는 경우
if z >= 99:
    print(-1)

else:
    start = 0
    end = 1000000000
    result = 0

    while start <= end:
        mid = (start + end) // 2
        if int((y + mid) * 100 // (x+mid)) <= z: #현재 승률이 평균보다 작은 경우
            start = mid + 1 #큰 수 범위로 넓혀줌
        else: #현재 승률이 평균보다 큰 경우
            result = mid
            end = mid - 1

    print(result)