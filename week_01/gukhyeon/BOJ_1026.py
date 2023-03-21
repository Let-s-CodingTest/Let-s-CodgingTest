import copy # 깊은복사 위해서 copy import
N = int(input())
A = list(map(int, input().split()))
B = list(map(int, input().split()))
A.sort() # 오름차순 정렬해야 B와 연산에서 최소값 가능
newB = copy.deepcopy(B) # B 를 newB에게 deep copy 해주어서 B에는 영향이 없고 newB에는 같은 값이 들어간다
newB.sort(reverse=True) # newB 리스트를 내림차순 정렬한다(A와 서로 어굿나야 최소 가능)
result2=0
for i in range(N): # A와 newB를 모두 순회하면서 서로 엇갈려 정렬된 인덱스끼리 곱하여 최소인 합을 출력한다.
    result2 += A[i] * newB[i]
print(result2)



# for i in range(N-1):
#     print("before")
#     print(A)
#     idx = B.index(newB[i])
#     print(idx)
#     temp = A[i]
#     A[i] = A[idx]
#     A[idx] = temp
#     print("After")
#     print(A)

# for i in range(N):
#     result += A[i] * B[i]
# print(result)
