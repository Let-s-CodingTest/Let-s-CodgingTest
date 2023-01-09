def solution(s):
    answer = True
    s2 = s.lower()
    pCnt = 0
    yCnt = 0
    for data in s2:
        if(data == 'y'):
            yCnt += 1
        if(data == 'p'):
            pCnt += 1
    if(pCnt==0 and yCnt ==0 ):
        return True
    else:
        if(pCnt == yCnt):
            return True
        else:
            return False
    return True