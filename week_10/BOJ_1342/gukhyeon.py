# import sys
 
# input = sys.readline.stdin

# def dfs(pre, pick):
#     answer = 0
#     if pick == len(words):
#         return 1
#     for key in counter.keys():
#         if pre == key or counter[key] == 0:
#             continue
#         counter[key] -= 1
#         answer += dfs(key, picked+1)
#         counter[key] += 1
#     return answer
            





# words = list(input().strip())
# counter = dict()
# for w in words:
#     if w in counter:
#         counter[w] += 1
#     else:
#         counter[w] = 1
# print(dfs('',0))
    

from sys import stdin
import sys
input = sys.stdin.readline
words = stdin.readline().rstrip() 

charCnt = [0] * 26 
for i in words:
    charCnt[ord(i) - 97] += 1

answer = 0
def dfs(lenwords, pre):
    global answer 
    
    if lenwords == 0:
        answer += 1
        return

    for c in set(list(words)):
        if charCnt[ord(c) - 97] > 0 and c != pre:
            charCnt[ord(c) - 97] -= 1
            dfs(lenwords - 1, c)
            charCnt[ord(c) - 97] += 1


dfs(len(words), '')
print(answer)