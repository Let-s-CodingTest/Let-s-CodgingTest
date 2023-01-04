def solution(x):
    answer = True
    sum = 0
    temp = x
    while 1:
        sum += x % 10
        if( x < 10):
            break
        x = x // 10
    if( temp %sum == 0 ):
        return answer
    else:
        return False
        
    return answer