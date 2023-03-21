
#using len - > list element
#using sum of digit -> list element
#using first letter (ascii)
from os import set_inheritable
import sys
input = sys.stdin.readline
N = int(input())
max = 451
twoDArr=[]
for i in range(N):
    serialList = []
    sum = 0
    element = input()
    element = element.replace('\n','')
    serialList.append(element)
    serialList.append(len(element))
    for data in element:
        if(data[0]>= '0' and data[0]<='9'):
            sum += int(data)

    if(sum!=0):
        serialList.append(sum)
    else:
        serialList.append(0)
    serialList.append(element[0])

    '''
    첫원소는 입력
    두번째는 길이
    세번째는 숫자들의 합
    네번째는 첫 글자->가 아니라 그냥 통째로 문자열 넣어도 sorted에서 비교해줌
    '''
    twoDArr.append(serialList)

twoDArr = sorted(twoDArr, key = lambda key:(key[1],key[2],key[0])) # 문자열도 통째로 비교해줌 (sorted, lambda)
for i in range(N):
    print(twoDArr[i][0])
