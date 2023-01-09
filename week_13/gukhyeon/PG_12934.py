def solution(n):
    
    answer = 0
    x = n ** (1/2)
    if(n % x == 0):
        answer =  (x+1)*(x+1)
    else:
        answer = -1
    return answer