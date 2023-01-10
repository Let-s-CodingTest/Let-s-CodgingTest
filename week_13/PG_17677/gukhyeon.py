import sys
input = sys.stdin.readline

str1, str2 = map(str,input().split())
s1Set = {}
s2Set = {}

str1 = str1.lower()
str2 = str2.lower()

for i in range(len(str1)-1):
    if(str1[i]<97 or str1[i]>122):
        continue
    s1Set.add(str1[i]+str1[i+1])
for i in range(len(str2)-1):
    if(str1[i]<97 or str1[i]>122):
        continue
    s2Set.add(str2[i]+str2[i+1])

unionSet = str1 | str2


