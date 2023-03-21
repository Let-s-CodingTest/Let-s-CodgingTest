import sys
from collections import deque
input = sys.stdin.readline
N, K = map(int,input().split())
belt = deque(map(int,input().split()))

robotPosition = deque()
cnt = 0
processCnt=0
for i in range(N):
    robotPosition.append(0)

while True:
    processCnt+=1
    robotPosition[0] = 1    
    belt[0] -= 1
    belt.rotate(1)
    robotPosition[N-1] =0
    for i in range(0,N-2):
        if(robotPosition[i+1] == 0 and belt[i+1] >= 1):
            robotPosition[i] = 0
            robotPosition[i+1] = 0
            robotPosition[N-1] =0
            belt[i] -= 1
    for i in range(N*2):
        if(belt[i] <= 0):
            cnt += 1
    if(cnt >= K):
        break

print(processCnt)
