import sys
input = sys.stdin.readline

n = int(input())

numbox=[1 for i in range(9)]

while n!=1:
    result = []
    for i in range(9):
        result.append(sum(numbox[max(0,i-2):min(19, i + 3 )]) % 987654321)
    numbox = result
    n = n-1
print(sum(numbox) % 987654321)