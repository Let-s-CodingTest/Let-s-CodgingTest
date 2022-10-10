import sys

input = sys.stdin.readline

n = int(input())
rank = [int(input()) for _ in range(n)]

rank.sort()  # 입력받은 등수 오름차순 정렬

sum = 0

for i in range(1, len(rank) + 1):
    sum += abs(rank[i - 1] - i)

print(sum)
