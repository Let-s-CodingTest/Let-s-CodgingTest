def binary_search(a, x):
    start, end = 0, len(a)-1

    while start <= end:
        mid = (start + end) // 2 #중간 인덱스
        if a[mid] > x:
            end = mid-1
        elif a[mid] < x:
            start = mid+1
        else:
            return 1
    return 0

n = int(input())
a = list(map(int, input().split()))
a.sort() #이진 탐색하려면 정렬이 된 상태여야 함
m = int(input())
nums = list(map(int, input().split()))

for i in nums:
    print(binary_search(a, i))