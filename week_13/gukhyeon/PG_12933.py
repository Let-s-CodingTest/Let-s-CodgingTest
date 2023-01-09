def solution(n):
    answer = 0
    numStr = list(str(n))
    numStr.sort(reverse=True)
    answer = int("".join(numStr))
    
        
    return answer