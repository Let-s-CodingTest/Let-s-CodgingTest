# 앞쪽으로 이동하는 요소는 1턴에 1칸이 최대인데,
# 뒤쪽으로 이동하는 요소는 1턴에 얼마든지 이동할 수 있다.
# 따라서, 같은 시간을 기준으로할 떄, 앞쪽 칸만을 이동하는 숫자들만 비교해야한다.
n = int(input())
A = []
for i in range(n):
    A.append(list((int(input()), i))) #배열의 인덱스도 함께 저장

sort_arr = sorted(A)
result = 0

for i in range(n):
    result = max(result, sort_arr[i][1] - i) #정렬 후 idx - 정렬 전 idx의 max값이 정렬 종료의 횟수
print(result + 1)
