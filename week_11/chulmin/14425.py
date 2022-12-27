import sys
input = sys.stdin.readline
n,m = map(int, input().split())
s = dict()
count = 0

for _ in range(n):
    s[input()] = True

for _ in range(m):
    if input() in s.keys():
        count+=1
print(count)