N, L = map(int, input().split())
fruitList =list(map(int,input().split()))
fruitList.sort()
if(fruitList[0] > L):
    print(L)
else:
    for i in range(N):
        if(fruitList[i] <= L):
            L += 1
        else:
            break
print(L)
