import sys
input = sys.stdin.readline
R, C = map(int,(input().split()))
midIndx=4
twoDArr= []
for i in range(R):
    newList=list(map(int,input().split()))
    twoDArr.append(newList)

T = int(input())
tempNum = []
i = 0
j = 0
jList=[]

cnt = 0
for i in range(R-2):
    for j in range(C-2):
        tempNum=[]
        for k in range(i,i+3):
            for m in range(j,j+3):
                tempNum.append(board[k][m])
        tempNum.sort()
        if(tempNum[midIndx] >= T):
            cnt += 1
print(cnt)

