#소수찾기
import math
from itertools import permutations

def is_prime(x):
    if x <= 1:
        return False
    for i in range(2, int(math.sqrt(x))+1):
        if x % i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    per=[]
    numbers=list(numbers)

    for i in range(1, len(numbers)+1):
        per+=list(permutations(numbers, i))
    new_num=[int("".join(p)) for p in per]

    for i in set(new_num):
        if is_prime(i):
            answer+=1
    return answer