import sys
from collections import deque

input=sys.stdin.readline
n, k=map(int, input().split())
belt=list(map(int, input().split()))
robots=[0]*n*2
cnt=0
while True :
    #과정 1 한칸 회전
    belt.insert(0, belt.pop(-1))
    #print(belt)
    robots.insert(0, robots.pop(-1))
    robots[n-1]=0 #로봇이 내리는 위치
    for i in range(n-2, -1, -1) : #n-1인덱스는 로봇이 내려갔으니까 그 다음 인덱스부터
        if robots[i]==1 and robots[i+1]==0 and belt[i+1]>=1 : #현재 위치에 로봇이 있고 이동할 위치에 로봇이 없고 벨트 내구도 1이상
            #로봇 이동 후 벨트 내구도 1 감소
            robots[i+1]=1
            robots[i]=0
            belt[i+1]-=1
    robots[n-1]=0 #내리는 위치 로봇 내리기
    if belt[0]>=1 and robots[0]==0 :
        robots[0]=1
        belt[0]-=1
    cnt+=1
    if belt.count(0)>=k :
        break
print(cnt)


