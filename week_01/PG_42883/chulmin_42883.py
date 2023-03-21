def solution(number, k):
    num = list(map(int, number))
    temp = num[0]
    count = 0 
    
    for i in range(1, len(num)+1):
        if num[i] >= temp:
            if count == k:
                break
            num.pop(temp)
            count+=1
            temp = num[i]
            
    return num