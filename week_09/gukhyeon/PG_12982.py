def solution(d, budget):
    answer = 0
    d.sort()
    for data in d:
        if(data <= budget):
            answer +=1
            budget -= data
    return answer
