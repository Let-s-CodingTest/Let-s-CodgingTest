import sys

input = sys.stdin.readline

N = int(input())
priceList =[]
for _ in range(N):
    priceList.append(int(input()))
priceList.sort(reverse=True)
priceResult = 0
for i in range(N):
    priceResult += priceList[i]
    if(i%3==2):
        priceResult -= priceList[i]
print(priceResult)