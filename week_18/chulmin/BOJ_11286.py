from queue import PriorityQueue
import sys
print=sys.stdout.write
input=sys.stdin.readline
n=int(input())
myQueue=PriorityQueue()

for i in range(n):
    x=int(input())

    if x==0:
        if myQueue.empty():
            print('0\n')
        else:
            result=myQueue.get()
            print(str(result[1])+'\n')
    else:
        #절댓값을 기준으로 정렬하고 같으면 음수 우선 정렬하도록 구성
        myQueue.put((abs(x),x))