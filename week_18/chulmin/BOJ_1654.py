#랜선 자르기
def cnt(nums, mid):
    cnt = 0
    for i in nums:
        cnt += i // mid
    return cnt

def binary_search(nums, s, e, n):
    if s > e:
        return e
    mid = (s + e) // 2  # (1 + 802) // 2 = 401

    if cnt(nums, mid) >= n:  # 타겟 목표와 우리가 자른 갯수가 같아지면
        s = mid + 1
        return binary_search(nums, s, e, n)
    else:  # cnt <n
        e = mid - 1
        return binary_search(nums, s, e, n)

k, n = map(int, input().split())  # 4 11 입력받음 , 4개의 랜선을 11개로 쪼개주어야 함.
line = [int(input()) for i in range(k)]
print(binary_search(line, 1, max(line), n))
