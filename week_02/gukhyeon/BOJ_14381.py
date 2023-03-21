import sys
from unittest import result
input = sys.stdin.readline
sleep = set([0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
T = int(input())
numList = []
for i in range(T):
    numList.append(int(input()))

for i in range(T):
        flag = 0
        resultSet = set([])
        while (flag != 1): # flat = 1은 0~9 숫자를 모두 가졌음을 의미한다.
            loopTempNum = numList[i]
            if(loopTempNum == 0): # 0은 아무리 곱해도 계속 0이므로 바로 끝낸다.
                print("Case #{}: INSOMNIA".format(i+1))
                flag=1 # while 문을 깨기 위한 조건
                continue # 밑의 코드를 실행하지 않고 넘어간다.
            multiple = 2 # 2부터 곱하기 시작하므로 2로 설정
            initialNum = numList[i] 
            change_initialNum = initialNum
            while(1):
                temp = loopTempNum % 10 #일의 자리 숫자 저장한다
                resultSet.add(temp) #set은 중복 허용 하지 않아서 이 자료구조로 이용한다. 
                if(len(sleep) == len(resultSet)): # 일의 자리만 add하므로 원소 갯수가 같아진다면 문제의 조건에 맞는 것이다.
                    print("Case #{}: {}".format(i+1,loopTempNum))
                    flag = 1
                    break
                if(loopTempNum > 10): #10보다 클 경우에는 while을 다시 돌려서 자릿수를 모두 더하기 위해 조건 걸어서 멈추게함.
                    loopWhileNum = loopTempNum
                    printNum = loopTempNum
                    loopTempNum = loopTempNum // 10 
                    while(loopWhileNum >= 10): # 10 이상일 경우 몫으로 나누어서 resultSet에 add한다
                        resultSet.add(loopWhileNum%10)
                        loopWhileNum = loopWhileNum // 10
                    resultSet.add(loopWhileNum)
                    
                    if(len(sleep) == len(resultSet)):
                        print("Case #{}: {}".format(i+1,printNum))
                        flag = 1
                        break
                    loopTempNum = change_initialNum * multiple
                    multiple += 1
                elif(loopTempNum <= 10): 
                    if(loopTempNum == 10): #10일 경우는 1과 0이므로 직접 삽입해준다.
                        resultSet.add(0)
                        resultSet.add(1)
                    else:
                        resultSet.add(loopTempNum) 
                    if(len(sleep) == len(resultSet)):
                        print("Case #{}: {}".format(i+1,loopTempNum))
                        flag = 1
                        break
                    loopTempNum = change_initialNum * multiple #여기까지오면 아직 set 이 완성되지 않은 것이므로 초기수에서 곱셈을 해준다.
                    multiple += 1