def solution(arr):
    answer = []
    min = 10e9
    idx = 0
    if(len(arr) == 1):
        answer.append(-1)
        return answer
    else:
        for i in arr:
            if(min > i):
                min = i
                returnIdx = idx
            idx += 1
        del arr[returnIdx]
    answer = arr.copy()
    return answer

print(solution([4,3,2,1]))