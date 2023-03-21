from fractions import Fraction
import sys
input = sys.stdin.readline
N = int(input())
numList = list(map(int, input().split()))

result = Fraction(1,10) + Fraction(3,10)

end = len(numList)

result = Fraction(1,numList[end-1])
for i in range(end,1,-1):
    result = numList[i-2] + result
    result = Fraction(1,result)

result = Fraction(1,1) - result
print("{} {}".format(result.numerator,result.denominator),end='')