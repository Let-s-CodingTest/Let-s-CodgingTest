import sys
input = sys.stdin.readline

t= int(input())

for _ in range(t):
  n = int(input())
  scores = [list(map(int, input().split())) for _ in range(n)]
  scores = sorted(scores, key=lambda a:a[0]) #서류 등수를 기준으로 오름차순
  
  temp = scores[0][1] #1등의 면접 등수
  count = 1 #1등을 포함하기 떄문에 1로 count
  
  for i in range(1,n):
    if temp > scores[i][1]:
      count+=1
      temp = scores[i][1]
  print(count)
  