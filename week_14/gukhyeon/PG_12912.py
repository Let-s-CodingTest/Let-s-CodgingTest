def solution(a, b):
    answer = 0
    if(a==b):
        return a
    elif(a>b):
        tmp = a
        a = b
        b = tmp
    for i in range(a,b+1):
        answer += i
    return answer