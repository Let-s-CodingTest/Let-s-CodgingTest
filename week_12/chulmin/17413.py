import sys
sys = sys.stdin.readline

n = list(input().rstrip())
idx = 0
start = 0

while idx < len(n):
    if n[idx] == '<':
        idx+=1
        while n[idx] != '>':
            idx+=1
        idx+=1  #닫힌 괄호를 만난 후 인덱스를 하나 증가

    elif n[idx].isalnum(): #숫자나 알파벳을 만나면
        start = idx
        while idx < len(n) and n[idx].isalnum():
            idx+=1
        tmp = n[start:idx] # 중간에 문자열들을 tmp라는 변수에 저장
        tmp.reverse() #뒤집기
        n[start:idx] = tmp

    else: #괄호도 아니고 알파벳, 숫자도 아닌 것 -> 공백 : 그냥 증가 시킨다
        idx+=1

print("".join(n))