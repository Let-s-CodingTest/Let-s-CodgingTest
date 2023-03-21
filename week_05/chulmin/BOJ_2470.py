import sys
input = sys.stdin.readline

n = int(input())
liquid = sorted(list(map(int, input().split())))

start = 0
end = n - 1
compare_value = abs(liquid[start] + liquid[end])

temp_s = start
temp_e = end

while start < end:
    temp = liquid[start] + liquid[end]

    if abs(temp) < compare_value:
        compare_value = abs(temp)
        temp_s = start
        temp_e = end
        if compare_value == 0:
            break
    #0보다 작으면 작은 수를 없애며 0에 가까워지도록 하기 위해 start idx + 1
    if temp < 0:
        start+=1
    #0보다 크다면 큰 수를 없애며 0에 가까워지도록 하기 위해 end idx -1
    else:
       end-=1

print(liquid[temp_s], liquid[temp_e])
