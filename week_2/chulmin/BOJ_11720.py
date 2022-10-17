n = int(input())
num = int(input())

sum = 0
list = []
# 일단 스트링으로 변경, 문자열로 변환한 담에 뿌려줄려고
for i in str(num):
    list.append(i)
# 뿌려진 문자열이 저장된 리스트에서 하나씩 받고
for i in list:
    sum+= int(i) #정수로 변환 후 덧셈
print(sum)