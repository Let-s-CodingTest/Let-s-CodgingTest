'''
기지국이 설치된 지점을 기준으로 계산
1. 현재 설치된 기지국 기준 왼쪽에 설치해야하는 개수를 계속 찾기
2. 마지막 기지국 기준으로 오른쪽에 설치해야하는 경우 추가
'''
import math

def solution(n, stations, w):
    answer = 0
    next=1
    for station in stations :
        if station-w-next>0:
            answer+=math.ceil((station-w-next)/(w*2+1))
        next=station+w+1
    if next<=n:
        answer+=math.ceil((n-next+1)/(w*2+1))
    return answer