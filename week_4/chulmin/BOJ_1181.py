n = int(input())
temp = [input() for _ in range(n)]
lst = list(set(temp))


lst.sort() # 알파벳 순 정렬
lst.sort(key=len) #길이 순 정렬

for i in lst:
    print(i)

