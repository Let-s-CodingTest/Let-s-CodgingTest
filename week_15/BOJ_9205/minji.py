import sys
from collections import deque
input=sys.stdin.readline

def bfs():
    q=deque()
    q.append([home[0], home[1]])
    while q:
        x, y=q.popleft()
        if abs(x-festival[0])+abs(y-festival[1])<=1000 :
            print("happy")
            return
        for i in range(n):
            if not visited[i] :
                new_x, new_y=conv[i]
                if abs(x-new_x)+abs(y-new_y)<=1000 :
                    q.append([new_x, new_y])
                    visited[i]=1
    print("sad")
    return
t=int(input())
for _ in range(t) :
    n=int(input())
    home=list(map(int, input().split()))
    conv=[]
    for _ in range(n) :
        conv.append(list(map(int, input().split())))
    festival=list(map(int, input().split()))
    visited=[0 for i in range(n+1)] #편의점 방문 체크
    bfs()