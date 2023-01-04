import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr=[]
for i in range(M):
    input_data = input().split()
    arr.append((int(input_data[0]),int(input_data[1]),(input_data[2])))
arr = sorted(arr,key = lambda key: (key[1],key[0],key[2]))

for i in range(M):
    print(arr[i][2],end='')