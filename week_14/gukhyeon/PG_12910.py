def solution(arr, divisor):
    answer = []
    cnt = 0
    for data in arr:
        if(data % divisor ==0):
            answer.append(data)
            cnt += 1
    if(cnt==0):
        answer.append(-1)
        
    answer.sort()
    return answer