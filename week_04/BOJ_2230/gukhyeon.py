import sys
input = sys.stdin.readline
N, M = map(int,(input().split()))
data = []
compare =[]
result = 1000000000
for i in range(N):
    data.append(int(input()))
for i in range(N):
    for j in range(i+1,N):
        diff = abs(data[j] - data[i])
        # compare.append(diff)
        if(diff>=M and diff not in compare):
            result = min(result, diff)
            # compare.append(diff)
             

# min = 1000000000
# for i in range(N):
#     if(compare[i]<M):
#         compare[i] = 999
#     if(compare[i]<min):
#         min = compare[i]
# print(min)
# compare.sort()
# print(compare[0])
print(result)



# import sys
# input = sys.stdin.readline
# N, M = map(int,(input().split()))
# data = []
# compare =[]
# for i in range(N):
#     data.append(int(input()))
# left, right = 0, 0
# ans = 1000000000

# while left < N and right < N:
#     diff = abs(data[left]-data[right])
#     if(diff < M):
#         right += 1
#     if(diff >= M):
#         left += 1
#         compare.append(diff)
# print(min(compare))
# # print(ans)

