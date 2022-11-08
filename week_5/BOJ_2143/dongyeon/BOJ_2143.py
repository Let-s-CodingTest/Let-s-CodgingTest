from itertools import combinations
from bisect import bisect_left, bisect_right
import sys
input = sys.stdin.readline

T = int(input())
n = int(input())
A = list(map(int, input().split()))
m = int(input())
B = list(map(int, input().split()))

sum_A = []
for i in range(1,n):
    sum_A+= [sum(x) for x in list(combinations(A, i)) if sum(x) <=T]

sum_B = []
for i in range(1,n):
    sum_B+= [sum(x) for x in list(combinations(B, i)) if sum(x) <=T]

sum_B.sort()

print(sum_A)
print(sum_B)