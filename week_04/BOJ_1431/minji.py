import sys
input=sys.stdin.readline

n=int(input())
numbers=[input().strip() for _ in range(n)]

def sum_of_num(num): #시리얼에서 숫자들의 합 반환
    result=0
    for i in num:
        if i.isdigit():
            result+=int(i)
    return result

#길이, sum_of_num의 결과, x 순으로 우선순위를 두고 정렬
numbers.sort(key=lambda x:(len(x), sum_of_num(x), x))

print(*numbers)