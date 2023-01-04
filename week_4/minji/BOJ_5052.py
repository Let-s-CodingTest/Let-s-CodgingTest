import sys
input=sys.stdin.readline

t=int(input())
for _ in range(t):
    n=int(input())
    numbers=[input().rstrip() for _ in range(n)]
    numbers.sort()
    flag=False
    for i in range(len(numbers)) :
        for j in range(i+1, len(numbers)) :
            if numbers[j][:len(numbers[i])]>numbers[i]:
                break
            if numbers[j][:len(numbers[i])] == numbers[i]:
                print("NO")
                flag=True
                break

        if flag==True :
            break
    if flag==False:
        print("YES")