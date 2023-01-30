'''
가장 먼집부터 배달하기
'''
def solution(cap, n, deliveries, pickups):
    answer = 0
    #가장 먼집부터 배달 -> 배열 뒤집기
    deliveries=deliveries[::-1]
    pickups=pickups[::-1]

    delivery_cnt=0
    pickup_cnt=0

    for i in range(n) :
        delivery_cnt+=deliveries[i]
        pickup_cnt+=pickups[i]
        while delivery_cnt > 0 or pickup_cnt > 0:
            delivery_cnt -= cap
            pickup_cnt -= cap
            answer += 2 * (n-i)

    return answer

print(solution(4, 5, [1, 0, 3, 1, 2], [0, 3, 0, 4, 0]))
print(solution(2, 7, [1, 0, 2, 0, 1, 0, 2], [0, 2, 0, 1, 0, 2, 0]))