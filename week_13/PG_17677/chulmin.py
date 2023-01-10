from collections import Counter

def solution(str1, str2):
    str1 = str1.upper()
    str2 = str2.upper()
    comp1,comp2 = [],[]

    #두글자씩 끊어서 다중 집합을 만들어준다.
    #공백, 숫자, 특문은 제거
    for i in range(len(str1)-1):
        if str1[i].isalpha() and str1[i+1].isalpha():
            comp1.append(str1[i:i+2]) #문자열 두글자씩 자르기

    for i in range(len(str2)-1):
        if str2[i].isalpha() and str2[i+1].isalpha():
            comp2.append(str2[i:i+2])

    print(comp1, comp2)

    cnt_comp1 = Counter(comp1)
    cnt_comp2 = Counter(comp2)

    print(cnt_comp1, cnt_comp2)

    inter = list((cnt_comp1 & cnt_comp2).elements()) #교집합 요소
    sum_set = list((cnt_comp1 | cnt_comp2).elements()) #합집합 요소

    print(inter, sum_set)

    if len(sum_set) == 0 and len(inter) == 0: #공집합
        return 65536
    else:
        return int(len(inter) / len(sum_set) * 65536)