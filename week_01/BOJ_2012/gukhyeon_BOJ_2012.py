from collections import deque
T = int(input())
rank=[]
result = []
for i in range(T):
    rank.append(i+1)
lst = list(map(int, input().split()))
for i in range(T):
    j=i+1
    for j in range(T):
        rank.append(abs(rank[i] - lst[j]))
print(min(rank))