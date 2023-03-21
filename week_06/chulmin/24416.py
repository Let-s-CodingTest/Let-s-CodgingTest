#재귀 호출에 비해 동적 프로그래밍이 얼마나 빠른지 확인해보는 문제

# recursive dp
def fib(n):
    count = 0
    if n == 1 or n == 2:
        return 1
    else:
        return fib(n-2) + fib(n-1)
        count+=1
    return count

def fibonacci(n):
    count = 0
    fibo = [0] * n

    fibo[0] = 1
    fibo[1] = 1
    for i in range(2, n):
        fibo[i] = fibo[i-2] +fibo[i-1]
        count+=1
    return count

n = int(input())
print(fib(n), fibonacci(n))