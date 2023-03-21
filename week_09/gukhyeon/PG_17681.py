def solution(n, arr1, arr2):
    answer = []
    newMap = []
    for i in range(n):
        addStr=""
        newMap.append(bin(arr1[i] | arr2[i]))
        newMap[i] = newMap[i][2:]
        for j in newMap[i] :
            if(j=='1'):
                addStr += "#"
            else:
                addStr += " "
        answer.append(addStr)
        newMap[i] = addStr
        
    

    return answer 
