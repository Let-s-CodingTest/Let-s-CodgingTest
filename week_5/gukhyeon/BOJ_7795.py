

# def binary(lst, start, end, target):
#     if(target >= lst[end]):
#         return end+1
#     while(start <= end):
#         mid = (start + end) //2
#         if(lst[mid] == target):
#             return mid+1
#         elif(lst[mid] > target):
#             if(lst[mid-1] <= target):
#                 return mid 
#             end = mid -1 
#         elif(lst[mid] < target):
#             if(lst[mid+1] > target):
#                 return mid+1
#             if(lst[mid+1] == target):
#                 return mid+2
#             start = mid + 1 
#     return -1
# input = sys.stdin.readline

# T = int(input())
# print(type(T))
#   # 테스트 개수
# result = []
# for i in range(T):
#     N, M = map(int,input().split())
#     cnt = 0
#     A = list(map(int, input().split()))
#     B = list(map(int, input().split()))
#     B.sort()
#     if(A[i] < B[0] ):
#         continue
#     for data in A:
#         resultData = (binary(B, 0, len(B)-1, data))
#         if(resultData != -1):
#             cnt += resultData
#     result.append(cnt)
# for i in range(T):
#     print(result[i])
    
import sys
input = sys.stdin.readline
T = int(input())
print(type(T))
  # 테스트 개수
result = []
for i in range(T):
    N, M = map(int,input().split())
    cnt = 0
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    A.sort()
    B.sort()
    for data in A:
        idx = 0
        if(data < B[0] ):
            continue
        if(data > B[len(B)-1] ):
            cnt += len(B)
            continue
        while(data > B[idx]):
            if(data > B[idx]):
                cnt+=1        
            idx+=1
            if(idx > len(B)-1):
                break
    result.append(cnt)
for i in range(T):
    print(result[i])