def solution(x, n):
    answer = []
    sum = x
    for i in range(n):
        answer.append(sum)
        sum += x
    return answer


'''
def solution(x, n):
    answer = []
    sum = x
    answer.append(x)
    for i in range(0,n):
        sum += x
        answer.append(sum)
    return answer

'''