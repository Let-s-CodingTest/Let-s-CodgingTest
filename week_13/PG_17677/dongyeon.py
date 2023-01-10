
def solution(str1, str2):
    s1 = [] # str1 다중 집합
    s2 = [] # str2 다중 집합

    # str1을 2글자씩 나눠서 모두 알파벳이면 대문자로 변경하여 집합에 추가한다.
    for i in range(len(str1)-1):
        tmp = str1[i:i+2]
        if tmp.isalpha():
            s1.append(tmp.upper())

    # str2을 2글자씩 나눠서 모두 알파벳이면 대문자로 변경하여 집합에 추가한다.
    for i in range(len(str2)-1):
        tmp = str2[i:i+2]
        if tmp.isalpha():
            s2.append(tmp.upper())

    if len(s1) == 0 and len(s2) == 0: # 공집합인 경우
        return 1*65536

    # 다중 집합 처리
    inter = sum([min(s1.count(i), s2.count(i)) for i in list(set(s1) & set(s2))])
    union = sum([max(s1.count(i), s2.count(i)) for i in list(set(s1) | set(s2))])

    answer = int((inter/union) * 65536)
    return answer

print(solution('aa1+aa2','AAAA12'))