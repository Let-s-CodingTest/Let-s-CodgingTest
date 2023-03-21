n = int(input())
time = []

for _ in range(n):
    s, f = map(int, input().split())
    time.append([s, f])

time = sorted(time, key=lambda s: s[0]) # 시작 시간 오름차순 정렬
time = sorted(time, key=lambda a: a[1]) # 종료 시간 기준으로 다시 오름차순
finish_time = 0 #마지막 회의시간, 0으로 설정하고 첫번째 원소부터 비교 
count = 0

for s, f in time:
    if s >= finish_time: # 회의 시작 시간 >= 이전 회의 종료 시간 
        finish_time = f #현재 회의 종료 시간으로 변경
        count += 1 
      
print(count)
