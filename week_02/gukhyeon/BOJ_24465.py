'''



'''
import sys
input = sys.stdin.readline
constellation=[]
for _ in range(12):
    constellation.append(0)
member = [] #현재 멤버 생일 저장
candidate = [] #후보자들 생일 저장

for _ in range(7):
    memberBirthday = list(map(int,input().split())) 
    member.append(memberBirthday)

N = int(input())
for _ in range(N):
    candidate.append(0)
for i in range(N):
    candidate[i] = (list(map(int,input().split())))

for i in range(len(member)): # for loop을 돌면서 각 별자리에 맞게, constellation 리스트에 1로 체크해줌.
    if((member[i][0] == 1 and member[i][1] >=20 and member[i][1] <=31) or (member[i][0] == 2 and member[i][1] >=1 and member[i][1] <=18)):
        constellation[0] = 1
    elif((member[i][0] == 2 and member[i][1] >=19 and member[i][1] <=29) or (member[i][0] == 3 and member[i][1] >=1 and member[i][1] <=20)):
        constellation[1] = 1
    elif((member[i][0] == 3 and member[i][1] >=21 and member[i][1] <=31 ) or (member[i][0] == 4 and member[i][1] >=1 and member[i][1] <=19)):
        constellation[2] = 1
    elif((member[i][0] == 4 and member[i][1] >=20 and member[i][1] <=30) or (member[i][0] == 5 and member[i][1] >=1 and member[i][1] <=20)):
        constellation[3] = 1
    elif((member[i][0] == 5 and member[i][1] >=21 and member[i][1] <=31) or (member[i][0] == 6 and member[i][1] >=1 and member[i][1] <=21)):
        constellation[4] = 1
    elif((member[i][0] == 6 and member[i][1] >=22 and member[i][1] <=30) or (member[i][0] == 7 and member[i][1] >=1 and member[i][1] <=22)):
        constellation[5] = 1
    elif((member[i][0] == 7 and member[i][1] >=23 and member[i][1] <=31) or (member[i][0] == 8 and member[i][1] >=1 and member[i][1] <=22)):
        constellation[6] = 1
    elif((member[i][0] == 8 and member[i][1] >=23 and member[i][1] <=31) or (member[i][0] == 9 and member[i][1] >=1 and member[i][1] <=22)):
        constellation[7] = 1
    elif((member[i][0] == 9 and member[i][1] >=23 and member[i][1] <=30) or (member[i][0] == 10 and member[i][1] >=1 and member[i][1] <=22)):
        constellation[8] = 1
    elif((member[i][0] == 10 and member[i][1] >=23 and member[i][1] <=31 ) or (member[i][0] == 11 and member[i][1] >=1 and member[i][1] <=22)):
        constellation[9] = 1
    elif((member[i][0] == 11 and member[i][1] >=23 and member[i][1] <=30 ) or (member[i][0] == 12 and member[i][1] >=1 and member[i][1] <=21)):
        constellation[10] = 1
    elif((member[i][0] == 12 and member[i][1] >=22 and member[i][1] <=31 ) or (member[i][0] == 1 and member[i][1] >=1 and member[i][1] <=19)):
        constellation[11] = 1


for i in range(len(candidate)): # for loop을 돌면서 별자리 체크하되 해당 별자리에 기존 멤버 있으면 후보자를 0으로 만들어서 자격 여부 판별함
    if((candidate[i][0] == 1 and candidate[i][1] >=20 and candidate[i][1] <=31) or (candidate[i][0] == 2 and candidate[i][1] >=1 and candidate[i][1] <=18)):
        if(constellation[0] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 2 and candidate[i][1] >=19 and candidate[i][1] <=29) or (candidate[i][0] == 3 and candidate[i][1] >=1 and candidate[i][1] <=20)):
        if(constellation[1] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 3 and candidate[i][1] >=21 and candidate[i][1] <=31 ) or (candidate[i][0] == 4 and candidate[i][1] >=1 and candidate[i][1] <=19)):
        if(constellation[2] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 4 and candidate[i][1] >=20 and candidate[i][1] <=30) or (candidate[i][0] == 5 and candidate[i][1] >=1 and candidate[i][1] <=20)):
        if(constellation[3] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 5 and candidate[i][1] >=21 and candidate[i][1] <=31) or (candidate[i][0] == 6 and candidate[i][1] >=1 and candidate[i][1] <=21)):
        if(constellation[4] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 6 and candidate[i][1] >=22 and candidate[i][1] <=30) or (candidate[i][0] == 7 and candidate[i][1] >=1 and candidate[i][1] <=22)):
        if(constellation[5] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 7 and candidate[i][1] >=23 and candidate[i][1] <=31) or (candidate[i][0] == 8 and candidate[i][1] >=1 and candidate[i][1] <=22)):
        if(constellation[6] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 8 and candidate[i][1] >=23 and candidate[i][1] <=31) or (candidate[i][0] == 9 and candidate[i][1] >=1 and candidate[i][1] <=22)):
        if(constellation[7] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 9 and candidate[i][1] >=23 and candidate[i][1] <=30) or (candidate[i][0] == 10 and candidate[i][1] >=1 and candidate[i][1] <=22)):
        if(constellation[8] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 10 and candidate[i][1] >=23 and candidate[i][1] <=31 ) or (candidate[i][0] == 11 and candidate[i][1] >=1 and candidate[i][1] <=22)):
        if(constellation[9] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 11 and candidate[i][1] >=23 and candidate[i][1] <=30 ) or (candidate[i][0] == 12 and candidate[i][1] >=1 and candidate[i][1] <=21)):
        if(constellation[10] == 1):
            candidate[i][0] = 0
    elif((candidate[i][0] == 12 and candidate[i][1] >=22 and candidate[i][1] <=31 ) or (candidate[i][0] == 1 and candidate[i][1] >=1 and candidate[i][1] <=19)):
        if(constellation[11] == 1):
            candidate[i][0] = 0
candidate.sort(key=lambda x:(x[0], x[-1])) ######### 2차원 배열을 첫번째, 두번째 원소로 각각 배열하는 방법, x 앞에 - 붙여주면 역순 정렬됨 (내림차순)
notMemberCnt = 0
for i in range(N):
    if((candidate[i][0]) != 0):
        print("{} {}".format(candidate[i][0],candidate[i][1]))
    if((candidate[i][0]) == 0):
        notMemberCnt += 1
    if(notMemberCnt == N):
        print("ALL FAILED")
        