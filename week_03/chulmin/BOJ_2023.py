import sys
sys.setrecursionlimit(10000)
input = sys.stdin.readline

n = int(input())

#소수 판별 알고리즘
def isPrime(number):
    for i in range(2, number//2 +1):
        if number % i == 0: # 1과 자기 자신이 아닌 수로 나누어지는 경우
            return False #소수가 아니므로 false 리턴
    return True # 그렇지 않은 경우에는 소수

def dfs(number):
    #넘어온 수가 입력받은 자릿수와 같으면 출력
    if len(str(number)) == n:
        print(number)
    #그렇지 않으면, 자릿수를 하나씪 늘려 나감
    else:
        for i in range(1, 10):
            #짝수 가지치기
            if i % 2 == 0:
                continue
            if isPrime(number * 10 + i):
                dfs(number * 10 + i) #재귀로 자릿수 늘려나감

dfs(2)
dfs(3)
dfs(5)
dfs(7)

